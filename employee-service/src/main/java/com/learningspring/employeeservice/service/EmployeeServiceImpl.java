package com.learningspring.employeeservice.service;

import com.learningspring.employeeservice.exception.ResourceNotFoundException;
import com.learningspring.employeeservice.model.dto.DepartmentDto;
import com.learningspring.employeeservice.model.dto.EmployeeDepartmentDto;
import com.learningspring.employeeservice.model.dto.EmployeeDto;
import com.learningspring.employeeservice.model.entity.Employee;
import com.learningspring.employeeservice.repository.EmployeeRepository;
import com.learningspring.employeeservice.service.feign.DepartmentServiceFeignImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final DepartmentServiceFeignImpl departmentServiceFeignImpl;

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
    public EmployeeDepartmentDto getEmployeeByIdRestTemplate(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", Long.toString(id)));

        String deptCode = employee.getDepartmentCode();
        final String URL = "http://localhost:8181/api/department/" + deptCode;

        ResponseEntity<DepartmentDto> responseEntity =
                restTemplate.getForEntity(URL, DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDepartmentDto employeeDepartmentDto =
                EmployeeDepartmentDto.builder()
                        .employee(employee)
                        .departmentDto(departmentDto)
                        .build();

        return employeeDepartmentDto;
    }

    @Override
    public EmployeeDepartmentDto getEmployeeByIdWebClient(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", Long.toString(id)));

        String deptCode = employee.getDepartmentCode();
        final String URL = "http://localhost:8181/api/department/" + deptCode;
        DepartmentDto departmentDto = webClient.get().uri(URL).retrieve().bodyToMono(DepartmentDto.class).block();

        EmployeeDepartmentDto employeeDepartmentDto =
                EmployeeDepartmentDto.builder()
                        .employee(employee)
                        .departmentDto(departmentDto)
                        .build();

        return employeeDepartmentDto;
    }

    @Override
    public EmployeeDepartmentDto getEmployeeByIdOpenFeign(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", Long.toString(id)));
        DepartmentDto departmentDto = departmentServiceFeignImpl.getDepartmentByCode(employee.getDepartmentCode());
        return EmployeeDepartmentDto.builder()
                .employee(employee)
                .departmentDto(departmentDto)
                .build();
    }

    @Override
    public Employee updateEmployee(long id, EmployeeDto employeeDto) {
        getEmployeeById(id);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return String.format("Employee with ID '%d' has been deleted successfully", id);
    }
}
