# springboot-microservices

## Section 1
> ### Lesson01 (department-service)
> ***
>- Create department_db
>- Add datasource properties
>- Create Deparment Entity
>- Create DepartmentRepository
>- Create DepartmentDto
>- Create DepartmentService
>- Create DepartmentController (POST & GET)

> ### Lesson02 (employee-service)
> ***
>- Create employee_db
>- Add datasource properties
>- Create Employee Entity
>- Create EmployeeRepository
>- Create EmployeeDto
>- Create EmployeeService
>- Create EmployeeController

* *

### Why Mapping Libraries are important?
Mapping libraries simplify the conversion from Entity to DTO, and from DTO to Entity in a Spring Boot REST API instead of writing these conversions by hand.

> ### Lesson03 (Mapping Libraries)
> ***
>✏️ Use ModelMapper/MapStruct Mapping Libraries to convert the JPA entity to its Dto and Vice Versa.
>- Add org.modelmapper:modelmapper dependency
>- Create new ModelMapper() Bean
>- mapper.map({Entity}Dto, {Entity}}.class); | mapper.map({Entity}}, {Entity}Dto.class);