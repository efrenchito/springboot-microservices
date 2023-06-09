package com.learningspring.departmentservice.controller;

import com.learningspring.departmentservice.model.dto.DepartmentDto;
import com.learningspring.departmentservice.model.entity.Department;
import com.learningspring.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return message;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        Department savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartments, HttpStatus.OK);
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<Department> getDepartmentByCode( @PathVariable("code") String code) {
        Department retrievedDepartment = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(retrievedDepartment, HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Department> updateDepartmentByCode(@PathVariable("code") String code, @RequestBody DepartmentDto departmentDto) {
        Department department = departmentService.updateDepartment(code, departmentDto);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("{code}")
    public ResponseEntity<String> deleteDepartmentByCode(@PathVariable String code) {
        String message = departmentService.deleteDepartmentByCode(code);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
