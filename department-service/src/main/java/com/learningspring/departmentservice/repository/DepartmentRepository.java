package com.learningspring.departmentservice.repository;

import com.learningspring.departmentservice.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByCode(String code);

    void deleteByCode(String code);
}
