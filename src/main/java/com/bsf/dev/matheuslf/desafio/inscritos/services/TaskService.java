package com.bsf.dev.matheuslf.desafio.inscritos.services;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.ProjectEntity;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.TaskEntity;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Priority;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Status;
import com.bsf.dev.matheuslf.desafio.inscritos.mappers.TaskMapper;
import com.bsf.dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import com.bsf.dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public TaskDTO createTask (TaskDTO dto,Long projectId){
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElseThrow(
                () ->  new RuntimeException("Project not found")//TODO: add custom exceptions
        );

        TaskEntity taskEntity = taskRepository.save(taskMapper.toEntity(dto));

        taskEntity.setProjectEntity(projectEntity);

        return taskMapper.toDTO(taskRepository.save(taskEntity));

    }

    public Page<TaskDTO> listTasks (Pageable pageable, Status status, Priority priority, Long projectId ){

        return taskRepository.findByFilters(pageable, status, priority, projectId)
                .map(taskMapper::toDTO);

    }
}


