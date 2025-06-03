package ru.tokyolifehard.taskmanager.mapper;

import org.springframework.stereotype.Component;
import ru.tokyolifehard.taskmanager.dto.ProjectDTO;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;
import ru.tokyolifehard.taskmanager.entity.Project;
import ru.tokyolifehard.taskmanager.entity.Task;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProjectMapper implements Mapper<Project, ProjectDTO>{

    private TaskMapper taskMapper;

    public ProjectMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());

        Set<TaskDTO> tasksDTO = dto.getTasks();

        Set<Task> tasks = tasksDTO.stream()
                .map(taskDTO -> taskMapper.toEntity(taskDTO))
                .collect(Collectors.toSet());

        project.setTasks(tasks);

        return project;
    }

    @Override
    public ProjectDTO toDto(Project entity) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(entity.getName());
        projectDTO.setDescription(entity.getDescription());
        projectDTO.setStatus(entity.getStatus());
        projectDTO.setStartDate(entity.getStartDate());
        projectDTO.setEndDate(entity.getEndDate());

        Set<Task> tasks = entity.getTasks();

        Set<TaskDTO> taskDTOSet = tasks.stream()
                .map(task -> taskMapper.toDto(task))
                .collect(Collectors.toSet());

        projectDTO.setTasks(taskDTOSet);

        return projectDTO;
    }
}
