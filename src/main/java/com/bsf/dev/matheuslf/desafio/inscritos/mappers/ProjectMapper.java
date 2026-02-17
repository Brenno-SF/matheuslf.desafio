package com.bsf.dev.matheuslf.desafio.inscritos.mappers;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.ProjectDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface ProjectMapper {
        ProjectDTO toProjectDTO(ProjectEntity projectEntity);
        ProjectEntity toProjectEntity(ProjectDTO projectDTO);
}
