package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not valid name")
    private String name;
    private int salary;
    public String gender;
    public String notes;
    public LocalDate startDate;
    public List<String> department;
}