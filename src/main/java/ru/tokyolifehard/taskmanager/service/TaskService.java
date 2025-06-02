package ru.tokyolifehard.taskmanager.service;

import org.springframework.stereotype.Service;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;
import ru.tokyolifehard.taskmanager.entity.Task;
import ru.tokyolifehard.taskmanager.mapper.TaskMapper;
import ru.tokyolifehard.taskmanager.repository.TaskRepository;


import java.lang.reflect.Field;

@Service
public class TaskService {


    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDTO getTaskById(Long id) {
        Task task = this.taskRepository.getTaskById(id);
        return this.taskMapper.toDto(task);
    }

    public void createTask(TaskDTO taskDTO) {
        this.taskRepository.createTask(taskDTO);
    }

    public void deleteById(Long id) {
        this.taskRepository.deleteTaskById(id);
    }

    public void updateTask(Long id,TaskDTO taskDTO) {
        this.taskRepository.updateTaskById(id,taskDTO);
    }


    public void modifyTask(Long id,TaskDTO incomeTaskDTO) {
        Task taskById = this.taskRepository.getTaskById(id);
        TaskDTO existsTaskDTO = this.taskMapper.toDto(taskById);
        try {
            patch(incomeTaskDTO,existsTaskDTO);
        }catch (IllegalAccessException e){
            e.getCause();
        }
        this.taskRepository.updateTaskById(id,existsTaskDTO);

    }

    private static void patch(TaskDTO income,TaskDTO exists) throws IllegalAccessException {
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
