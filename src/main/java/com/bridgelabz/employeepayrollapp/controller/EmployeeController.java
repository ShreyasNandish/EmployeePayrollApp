package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Added employee",employeeService.addEmployee(employeeDTO));
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,@PathVariable long id){
        ResponseDTO responseDTO = new ResponseDTO("updated employee details",employeeService.updateEmployee(employeeDTO,id));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id){
        ResponseDTO responseDTO = new ResponseDTO("deleted employee",employeeService.deleteEmployee(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getEmployeebyId(@PathVariable long id){
        ResponseDTO responseDTO = new ResponseDTO("Employee displayed",employeeService.getEmployeeByID(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getallemployees")
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        ResponseDTO responseDTO = new ResponseDTO("Employee displayed", employeeService.getAllEmployees());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
