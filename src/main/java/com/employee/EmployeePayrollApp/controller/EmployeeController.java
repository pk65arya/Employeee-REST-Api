package com.employee.EmployeePayrollApp.controller;

import com.employee.EmployeePayrollApp.entity.Employee;
import com.employee.EmployeePayrollApp.entity.ResponseDTO;
import com.employee.EmployeePayrollApp.service.EmployeeImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employedata")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {

    @Autowired
    EmployeeImpl employeeImpl;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody Employee employee) {
        System.out.println("Received employee data: " + employee.toString()); // Debug log
        Employee employee1 = employeeImpl.createEmployeeData(employee);
        ResponseDTO responseDTO = new ResponseDTO("Created employee data successfully", employee1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getemployeelist")
    public ResponseEntity<ResponseDTO> getEmployeeList() {
        ResponseDTO responseDTO = new ResponseDTO("Returning list ", employeeImpl.getAllEmployeeData());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer employeeId) {
        Employee employee = employeeImpl.getEmployeeById(employeeId);

        ResponseDTO responseDTO = new ResponseDTO("returning By Id", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        Employee updateUser = employeeImpl.updateEmployeePayrollData(employee);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
        employeeImpl.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}