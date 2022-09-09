package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gender;
    @ElementCollection
    @CollectionTable(name="department",joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    private int salary;
    private LocalDate startDate;
    private String notes;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee(String name, String gender, int salary, LocalDate startDate, String notes, List<String> department) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
        this.department = department;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public Employee() {
    }

//public Employee(EmployeeDTO employeeDTO,String gender,LocalDate startDate, String notes){
//    this.name = employeeDTO.getName();
//    this.salary = employeeDTO.getSalary();
//    this.department = employeeDTO.getDepartment();
//    this.gender = gender;
//    this.startDate = startDate;
//    this.notes = notes;
//}
    public Employee(EmployeeDTO employeeDTO){
        this.name = employeeDTO.getName();
        this.gender = employeeDTO.getGender();
        this.notes = employeeDTO.getNotes();
        this.startDate = employeeDTO.getStartDate();
        this.salary = employeeDTO.getSalary();
        this.department = employeeDTO.getDepartment();
        this.email =employeeDTO.getEmail();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
