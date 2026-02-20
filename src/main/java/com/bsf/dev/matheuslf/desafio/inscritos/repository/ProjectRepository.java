package com.bsf.dev.matheuslf.desafio.inscritos.repository;

import com.bsf.dev.matheuslf.desafio.inscritos.entities.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    @Query("select p from ProjectEntity p left join fetch p.tasks")
    Page<ProjectEntity> getAllProjects(Pageable pageable);

}
