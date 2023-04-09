package com.learningspring.employeeservice.repository;

import com.learningspring.employeeservice.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
