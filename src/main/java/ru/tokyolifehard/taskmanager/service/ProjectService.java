package ru.tokyolifehard.taskmanager.service;


import org.springframework.stereotype.Service;
import ru.tokyolifehard.taskmanager.dto.ProjectDTO;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;
import ru.tokyolifehard.taskmanager.entity.Project;
import ru.tokyolifehard.taskmanager.mapper.ProjectMapper;
import ru.tokyolifehard.taskmanager.repository.ProjectRepository;

import java.lang.reflect.Field;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public ProjectDTO getProjectById(Long projectId) {
        Project project = this.projectRepository.getProjectById(projectId);
        return this.projectMapper.toDto(project);
    }

    public void createProject(ProjectDTO projectDTO) {
        this.projectRepository.createProject(projectDTO);
    }

    public void updateProject(Long projectId, ProjectDTO projectDTO) {
        this.projectRepository.updateProjectById(projectId,projectDTO);
    }

    public void modifyProject(Long projectId, ProjectDTO projectDTO) {
        Project project = this.projectRepository.getProjectById(projectId);
        ProjectDTO dto = this.projectMapper.toDto(project);
        try {
            patch(projectDTO,dto);
        }catch (IllegalAccessException e){
            e.getCause();
        }
        this.projectRepository.updateProjectById(projectId,dto);
    }

    public void deleteById(Long projectId) {
        this.projectRepository.deleteProjectById(projectId);
    }

    private static void patch(ProjectDTO income, ProjectDTO exists) throws IllegalAccessException {
        Class<?> taskDtoClazz = TaskDTO.class;
        Field[] declaredFields = taskDtoClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(income);
            if(value!=null){
                declaredField.set(exists,value);
            }
            declaredField.setAccessible(false);
        }
    }
}
