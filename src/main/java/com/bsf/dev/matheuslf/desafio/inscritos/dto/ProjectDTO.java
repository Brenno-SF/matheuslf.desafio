package com.bsf.dev.matheuslf.desafio.inscritos.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ProjectDTO(
        Long projectId,
        String name,
        String description,
        LocalDateTime startDate,
        LocalDateTime endDate,
        List<TaskDTO> tasks
) {
}
