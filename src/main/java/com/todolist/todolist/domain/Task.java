package com.todolist.todolist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {

    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    private String status;

}
