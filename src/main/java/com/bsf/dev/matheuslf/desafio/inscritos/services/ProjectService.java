package com.bsf.dev.matheuslf.desafio.inscritos.services;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.ProjectDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.ProjectEntity;
import com.bsf.dev.matheuslf.desafio.inscritos.mappers.ProjectMapper;
import com.bsf.dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }


    public ProjectDTO createProject(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = projectMapper.toProjectEntity(projectDTO);

        return projectMapper.toProjectDTO(projectRepository.save(projectEntity));

    }
}
