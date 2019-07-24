package com.example.model.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PersonResponse {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
}
