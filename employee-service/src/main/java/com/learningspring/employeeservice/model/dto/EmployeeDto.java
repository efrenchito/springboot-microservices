package com.learningspring.employeeservice.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    @NotEmpty(message = "firstName can NOT be empty")
    private String firstName;
    @NotEmpty(message = "lastName can NOT be empty")
    private String lastName;
    @NotEmpty(message = "email can NOT be empty")
    @Email(message = "email should have a valid format")
    private String email;
}
