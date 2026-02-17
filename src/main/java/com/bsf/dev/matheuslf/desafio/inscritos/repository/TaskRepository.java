package com.bsf.dev.matheuslf.desafio.inscritos.repository;

import com.bsf.dev.matheuslf.desafio.inscritos.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("select t from TaskEntity t left join fetch t.projectEntity")
    List<TaskEntity> getAllTasks();
}
