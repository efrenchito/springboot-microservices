package com.learningspring.employeeservice.controller;

import com.learningspring.employeeservice.model.dto.EmployeeDepartmentDto;
import com.learningspring.employeeservice.model.dto.EmployeeDto;
import com.learningspring.employeeservice.model.entity.Employee;
import com.learningspring.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/rest-template/{id}")
    public ResponseEntity<EmployeeDepartmentDto> getEmployeeByIdRestTemplate(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getEmployeeByIdRestTemplate(id));
    }

    @GetMapping("/web-client/{id}")
    public ResponseEntity<EmployeeDepartmentDto> getEmployeeByIdWebClient(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getEmployeeByIdWebClient(id));
    }

    @GetMapping("/open-feign/{id}")
    public ResponseEntity<EmployeeDepartmentDto> getEmployeeByIdOpenFeign(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getEmployeeByIdOpenFeign(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id, @Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
