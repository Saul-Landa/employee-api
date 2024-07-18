package com.slanda.employee_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    @Size(max = 60, message = "Name cannot be longer than 60 characters.")
    @NotBlank(message = "Name is required.")
    private String name;

    @Size(max = 80, message = "Position cannot be longer than 80 characters.")
    @NotBlank(message = "Position is required.")
    private String position;

    @Min(1)
    private double salary;
}
