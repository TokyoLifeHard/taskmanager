package ru.tokyolifehard.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @GetMapping
    public ResponseEntity<?> getTask(){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createTask(){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateTask(){
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<?> modifyTask(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTask(){
        return ResponseEntity.ok().build();
    }


}
