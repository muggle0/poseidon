package com.sofia.poseidon.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Date birthDate;
}
