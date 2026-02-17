package com.bsf.dev.matheuslf.desafio.inscritos.dto;

import com.bsf.dev.matheuslf.desafio.inscritos.enums.Priority;
import com.bsf.dev.matheuslf.desafio.inscritos.enums.Status;

import java.time.LocalDateTime;

public record TaskDTO(Long taskId,
                      String title,
                      String description,
                      LocalDateTime startDate,
                      Priority priority,
                      Status status,
                      Long projectId) {
}
