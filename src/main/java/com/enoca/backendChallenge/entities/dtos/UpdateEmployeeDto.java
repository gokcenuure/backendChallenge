package com.enoca.backendChallenge.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeDto {

    private String name;

    private String surname;

    private String email;

    private String password;

    private String position;

    private int companyId;
}
