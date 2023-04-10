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

* *

### Exception Handling Overview
When an Exception occurs Spring Boot returns {timestamp|status|error|trace|message|path} as default response.  
Usually we'll require to create a custom response, accordingly to Customer needs.

### What are the most important annotations for handling Exceptions in the Spring Boot application?
* @ControllerAdvice - Defines a class to handle Exceptions Globally
* @ExceptionHandler - Handle specific exceptions and send the custom responses to the client.
* @ResponseStatus - Spring Boot responds with this HttpStatus whenever this exception is thrown

> ### Lesson04 (Exception Handling)
> ***
>✏️ Create a Global Exception Handler class
>- Create custom ErrorDetails class to hold the custom error response
>- Create GlobalExceptionHandler class and handle global Exceptions in a single place.
>- Create ResourceNotFoundException and throw it properly
>- Handle specific ResourceNotFoundException on GlobalExceptionHandler