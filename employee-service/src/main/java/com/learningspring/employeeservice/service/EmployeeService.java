package com.learningspring.employeeservice.service;

import com.learningspring.employeeservice.model.dto.EmployeeDepartmentDto;
import com.learningspring.employeeservice.model.dto.EmployeeDto;
import com.learningspring.employeeservice.model.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public Employee createEmployee(EmployeeDto employeeDto);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(long id);

    EmployeeDepartmentDto getEmployeeByIdRestTemplate(long id);

    EmployeeDepartmentDto getEmployeeByIdWebClient(long id);

    EmployeeDepartmentDto getEmployeeByIdOpenFeign(long id);

    public Employee updateEmployee(long id, EmployeeDto employeeDto);

    public String deleteEmployee(long id);
}
