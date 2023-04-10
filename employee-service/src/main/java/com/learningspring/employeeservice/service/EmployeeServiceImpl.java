package com.learningspring.employeeservice.service;

import com.learningspring.employeeservice.exception.ResourceNotFoundException;
import com.learningspring.employeeservice.model.dto.EmployeeDto;
import com.learningspring.employeeservice.model.entity.Employee;
import com.learningspring.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;


    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", Long.toString(id)));
    }

    @Override
    public Employee updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(id);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return String.format("Employee with ID '%d' has been deleted successfully", id);
    }
}
