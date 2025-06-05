package ru.tokyolifehard.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tokyolifehard.taskmanager.dto.ProjectDTO;
import ru.tokyolifehard.taskmanager.service.ProjectService;

@RestController
@RequestMapping("/api/v1/projects")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;

    @GetMapping(path = "{projectId}",consumes = "application/json", produces = "application/json")
    public ProjectDTO getProjectById(@PathVariable String projectId){
        return this.projectService.getProjectById(Long.valueOf(projectId));
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getProjects(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "desc") int sort

    ){
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createProject(@RequestBody ProjectDTO projectDTO){
        this.projectService.createProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateProject(@PathVariable String projectId,@RequestBody ProjectDTO projectDTO){
        this.projectService.updateProject(Long.valueOf(projectId),projectDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> modifyTask(@PathVariable String projectId,@RequestBody ProjectDTO projectDTO){
        this.projectService.modifyProject(Long.valueOf(projectId),projectDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{taskId}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteTask(@PathVariable String projectId){
        this.projectService.deleteById(Long.valueOf(projectId));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
