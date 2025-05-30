package ru.tokyolifehard.taskmanager.mapper;

import org.springframework.stereotype.Component;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;
import ru.tokyolifehard.taskmanager.entity.Task;

@Component
public class TaskMapper implements Mapper<Task,TaskDTO> {

    @Override
    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getLeadTime());
        task.setCreatedAt(dto.getCreatedAt());
        task.getProject().setName(dto.getProjectName());
        return task;
    }

    @Override
    public TaskDTO toDto(Task entity) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(entity.getTitle());
        taskDTO.setDescription(entity.getDescription());
        taskDTO.setPriority(entity.getPriority());
        taskDTO.setCreatedAt(entity.getCreatedAt());
        taskDTO.setLeadTime(entity.getCreatedAt());
        taskDTO.setProjectName(entity.getProject().getName());
        return taskDTO;
    }
}
