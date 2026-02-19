package com.bsf.dev.matheuslf.desafio.inscritos.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    @Column(name = "project_id")
    private Long projectId;

    @Column(length = 100)
    private String name;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date")
    @CreationTimestamp
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;
}
