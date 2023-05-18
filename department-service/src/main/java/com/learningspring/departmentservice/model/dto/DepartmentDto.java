package com.learningspring.departmentservice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Department model information")
public class DepartmentDto {

    @ApiModelProperty(value = "Code used internally")
    @NotBlank(message = "code field can NOT be empty")
    public String code;
    @ApiModelProperty(value = "Official name")
    public String name;
    @ApiModelProperty(value = "Ful description of department")
    public String description;
}
