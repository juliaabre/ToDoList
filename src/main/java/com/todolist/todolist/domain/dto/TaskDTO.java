package com.todolist.todolist.domain.dto;

import java.time.LocalDate;

public record TaskDTO(Long id,
                      String title,
                      String description,
                      LocalDate date,
                      String status) {
}
