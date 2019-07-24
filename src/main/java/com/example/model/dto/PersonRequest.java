package com.example.model.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonRequest {

    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
}
