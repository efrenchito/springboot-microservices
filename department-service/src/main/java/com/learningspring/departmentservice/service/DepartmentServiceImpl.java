package com.learningspring.departmentservice.service;

import com.learningspring.departmentservice.model.dto.DepartmentDto;
import com.learningspring.departmentservice.model.entity.Department;
import com.learningspring.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public Department createDepartment(DepartmentDto departmentDto) {
        Department department = Department.builder()
                .code(departmentDto.getCode())
                .name(departmentDto.getName())
                .description(departmentDto.getDescription())
                .build();
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByCode(String code) {
        return departmentRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException(String.format("Department with code %s NOT FOUND ", code)));
    }

    @Override
    public Department updateDepartment(String code, DepartmentDto departmentDto) {
        Department department = getDepartmentByCode(code);
        department.setCode(departmentDto.getCode());
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        return departmentRepository.save(department);
    }

    @Override
    public String deleteDepartmentByCode(String code) {
        Department department = getDepartmentByCode(code);
        departmentRepository.delete(department);
        return String.format("Department '%s - %s' successfully deleted", department.getCode(), department.getName());
    }
}
