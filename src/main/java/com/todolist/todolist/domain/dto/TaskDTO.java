package com.todolist.todolist.domain.dto;

import java.time.LocalDate;

public record TaskDTO(String title,
                      String description,
                      LocalDate date,
                      String status) {
}
