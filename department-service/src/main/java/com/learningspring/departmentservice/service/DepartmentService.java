package com.learningspring.departmentservice.service;

import com.learningspring.departmentservice.model.dto.DepartmentDto;
import com.learningspring.departmentservice.model.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {

    public Department createDepartment(DepartmentDto departmentDto);

    public List<Department> getAllDepartments();

    public Department getDepartmentByCode(String code);

    public Department updateDepartment(String code, DepartmentDto departmentDto);

    public String deleteDepartmentByCode(String code);

}
