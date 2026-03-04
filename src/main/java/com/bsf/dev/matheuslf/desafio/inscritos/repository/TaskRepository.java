package com.bsf.dev.matheuslf.desafio.inscritos.repository;

import com.bsf.dev.matheuslf.desafio.inscritos.dto.TaskDTO;
import com.bsf.dev.matheuslf.desafio.inscritos.entities.TaskEntity;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Priority;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("select t from TaskEntity t left join fetch t.projectEntity")
    List<TaskEntity> getAllTasks();

    @Query(
            """
                   select t from TaskEntity t
                   where(:status IS NULL OR t.status = :status)
                   and (:priority IS NULL OR t.priority = :priority)
                   and (:projectId IS NULL OR t.projectEntity.projectId = :projectId) 
                    """
    )
    Page<TaskEntity> findByFilters(Pageable pageable, Status status, Priority priority, Long projectId);
}
