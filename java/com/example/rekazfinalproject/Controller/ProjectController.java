package com.example.rekazfinalproject.Controller;

import com.example.rekazfinalproject.Model.Project;
import com.example.rekazfinalproject.Service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")

public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/get-all-projects")
    public ResponseEntity getAllProjects() {
        return ResponseEntity.status(200).body(projectService.getAllProjects());
    }

    @PostMapping("/add-project")
    public ResponseEntity addProject(@Valid  @RequestBody  Project project) {
        projectService.addProject(project);
        return ResponseEntity.status(200).body("project added successfully");
    }

    @PutMapping("/update-project/{id}")
    public ResponseEntity updateProject( @PathVariable  int id , @Valid  @RequestBody Project project) {
        projectService.updateProject(id, project);
        return ResponseEntity.status(200).body("project updated successfully");
    }

    @DeleteMapping("/delete-project/{id}")
    public ResponseEntity deleteProject( @PathVariable  int id) {
        projectService.deleteProject(id);
        return ResponseEntity.status(200).body("project deleted successfully");
    }
}
