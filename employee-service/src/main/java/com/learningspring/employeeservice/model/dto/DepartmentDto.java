package com.learningspring.employeeservice.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
    private String code;
    private String name;
    private String description;
}
