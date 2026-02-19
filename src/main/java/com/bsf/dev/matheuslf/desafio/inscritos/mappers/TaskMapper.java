package com.bsf.dev.matheuslf.desafio.inscritos.mappers;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.ProjectEntity;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "projectEntity.projectId", target = "projectId")
    TaskDTO toDTO(TaskEntity entity);

    @Mapping(source = "projectId", target = "projectEntity.projectId")
    TaskEntity toEntity(TaskDTO dto);

    default ProjectEntity map(Long projectId) {
        if (projectId == null) return null;

        ProjectEntity project = new ProjectEntity();
        project.setProjectId(projectId);
        return project;
    }
}
