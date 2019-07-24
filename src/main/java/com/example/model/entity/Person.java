package com.example.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
public class Person {

    //public default constructor

    //primary key
    @Id

    //autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "my_email", unique = true, length = 50)
    private String email;


    private String name;
    private LocalDate dateOfBirth;
    private String phoneNumber;
}
