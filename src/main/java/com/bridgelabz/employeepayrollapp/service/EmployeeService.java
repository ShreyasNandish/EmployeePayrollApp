package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeByID(long id){
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO,long id)
    {
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    public String deleteEmployee(long id)
    {
        employeeRepository.deleteById(id);
        return "deleted contact";
    }
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

}
