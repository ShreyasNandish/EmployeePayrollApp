package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee addEmployee(EmployeeDTO employeeDTO);
    Employee updateEmployee(EmployeeDTO employeeDTO,long id);
    String deleteEmployee(long id);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeByID(long id);

}
