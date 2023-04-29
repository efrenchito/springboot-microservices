package com.learningspring.employeeservice.service.feign;

import com.learningspring.employeeservice.model.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(url = "http://localhost:8181;http://localhost:8182", value = "department-service")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentServiceFeignImpl {

    @GetMapping("/api/department/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);
}
