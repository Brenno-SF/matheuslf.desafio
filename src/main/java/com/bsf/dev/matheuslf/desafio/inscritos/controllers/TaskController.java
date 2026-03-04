package com.bsf.dev.matheuslf.desafio.inscritos.controllers;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.ProjectDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Priority;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Status;
import com.bsf.dev.matheuslf.desafio.inscritos.services.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create/{projectId}")//TODO: maybe change this
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@RequestBody TaskDTO dto, @PathVariable Long projectId){
        return taskService.createTask( dto, projectId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskDTO> listAll(@RequestParam(required = false) Status status,
                                 @RequestParam(required = false) Priority priority,
                                 @RequestParam(required = false) Long projectId,
                                Pageable pageable){
        return taskService.listTasks(pageable, status,priority, projectId);
    }
}
