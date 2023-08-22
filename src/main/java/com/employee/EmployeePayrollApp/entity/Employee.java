package com.employee.EmployeePayrollApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employeetb")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;
    private String gender;
    private Date startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    private List<String> department;

    // Add a default constructor
    public Employee() {
    }

    // Add a copy constructor
    public Employee(Employee employee) {
        this.name = employee.getName();
        this.gender = employee.getGender();
       this.startDate = new Date();
        this.note = employee.getNote();
        this.profilePic = employee.getProfilePic();
       this.department = employee.getDepartment();
    }
}
