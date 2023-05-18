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

* *

### Bean Validation
o We validate a Java Bean with the Standard Framework - JSR 380, also known as Bean Validation 2.0
o Validating User Input is a Super Common Requirement in most applications. and the Java Bean Validation Framework has become the de facto standard for handling this kind of logic.  
o JSR 380 is a specification of the Java Bean Validation API and this ensures that the properties of a bean meet specific criteria, using annotations such as @NotNull, @Min, and @Max  
o Hibernate Validator is the reference implementation of the validation API


> ### Lesson05 (Bean Validation)
> ***
>✏️ Add Bean Validation
>- Add org.springframework.boot:spring-boot-starter-validation
>- Apply desired validation annotations to Dto bean. e.g: @NotNull|@NotBlank|@NotEmpty|@Size|@Min|@Max|@Email
>- Enable validation on Spring Controller by adding ️@Valid️ @RequestBody annotations
>- Add handler to 'MethodArgumentNotValidException.class' in GlobalExceptionHandler
> ***
 
### Open API ( Swagger )

Defines a standard __language-agnostic__ interface to HTTP APIs which allow to discover and understand the capabilities 
of a service without access to the source code

> ### Lesson06 ( Open API Swagger )
> ***
> ✏️ Add OpenAPI Swagger
> - Add io.springfox:springfox-boot-starter
> - Open in your browser http://localhost:8181/v3/api-docs
> - Open in your browser http://localhost:8181/swagger-ui/
> - Add configuration
> ***