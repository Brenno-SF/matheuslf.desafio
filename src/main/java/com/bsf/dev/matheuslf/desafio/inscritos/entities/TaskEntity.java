package com.bsf.dev.matheuslf.desafio.inscritos.entities;

import com.bsf.dev.matheuslf.desafio.inscritos.enums.Priority;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(length = 150)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date")
    @CreationTimestamp
    private LocalDateTime startDate;

    private Priority priority;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "project_id_fk")
    private ProjectEntity projectEntity;

}
