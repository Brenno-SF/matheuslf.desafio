package com.bsf.dev.matheuslf.desafio.inscritos.controllers;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.ProjectDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.services.ProjectService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(
                projectService.createProject(projectDTO));
    }
}
