package ru.tokyolifehard.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tokyolifehard.taskmanager.dto.TaskDTO;
import ru.tokyolifehard.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping(path = "/{taskId}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<TaskDTO> getTask(@PathVariable String taskId){
        TaskDTO task = this.taskService.getTaskById(Long.valueOf(taskId));

        return ResponseEntity.ok(task);
    }

    @GetMapping(path = "/{taskId}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getTasks(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "desc") int sort

    ){
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createTask(TaskDTO taskDTO){
        this.taskService.createTask(taskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateTask(@PathVariable String taskId,TaskDTO taskDTO){
        this.taskService.updateTask(Long.valueOf(taskId),taskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> modifyTask(String taskId,TaskDTO incomeTaskDTO){
        TaskDTO taskDTO = taskService.getTaskByTitle(incomeTaskDTO.getTitle());
        this.taskService.modifyTask(Long.valueOf(taskId),incomeTaskDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{taskId}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteTask(@PathVariable String taskId){
        taskService.deleteById(Long.valueOf(taskId));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
