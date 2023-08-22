package com.employee.EmployeePayrollApp.service;

import com.employee.EmployeePayrollApp.dao.Employeedao;
import com.employee.EmployeePayrollApp.entity.Employee;
import com.employee.EmployeePayrollApp.entity.ResponseDTO;

import java.util.List;

public interface IEmployee {

    Employee createEmployeeData(Employee employee);

    List<Employee> getAllEmployeeData();

    Employee getEmployeeById(Integer employeeId);


    Employee updateEmployeePayrollData(Employee employee);

    void deleteUser(int Id);
}
