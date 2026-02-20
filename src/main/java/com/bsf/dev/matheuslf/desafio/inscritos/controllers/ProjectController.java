package com.bsf.dev.matheuslf.desafio.inscritos.controllers;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.ProjectDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.services.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProjectDTO> listAll(Pageable pageable){
        return projectService.listAllProjects(pageable);
    }


}
