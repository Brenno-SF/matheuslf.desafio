package com.bsf.dev.matheuslf.desafio.inscritos.entities;

import com.bsf.dev.matheuslf.desafio.inscritos.enums.Priority;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
    @Column(name = "task_id")
    private Long taskId;

    @Column(length = 150)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date")
    @CreationTimestamp
    private LocalDateTime startDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "project_id_fk")
    private ProjectEntity projectEntity;

}
