package com.learningspring.employeeservice.model.dto;

import com.learningspring.employeeservice.model.entity.Employee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDepartmentDto {
    private Employee employee;
    private DepartmentDto departmentDto;
}
