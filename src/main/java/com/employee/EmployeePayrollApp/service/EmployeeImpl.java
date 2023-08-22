package com.employee.EmployeePayrollApp.service;


import com.employee.EmployeePayrollApp.entity.Employee;
import com.employee.EmployeePayrollApp.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeImpl implements IEmployee {

    @Autowired
    EmployeeRepo employeeRepo;


    @Override
    public Employee createEmployeeData(Employee employee) {
        Employee empdata = new Employee(employee);
        log.debug("Emp data :" + empdata.toString()); // Debug log
        return employeeRepo.save(empdata);
    }

    @Override
    public List<Employee> getAllEmployeeData() {
        try {
            return employeeRepo.findAll();
        } catch (Exception ex) {
            log.info("Error occured {} ", ex.getStackTrace());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
        return optionalEmployee.get();
    }

    @Override
    public Employee updateEmployeePayrollData(Employee employee) {
        Employee employee1 = employeeRepo.findById(employee.getEmployeeId()).get();
        employee1.setName(employee.getName());
        employee1.setGender(employee.getGender());
        employee1.setStartDate(employee.getStartDate());
        employee1.setNote(employee.getNote());

        employee1.setProfilePic(employee.getProfilePic());
        employee1.setDepartment(employee.getDepartment());

        Employee updateUser = employeeRepo.save(employee1);
        return updateUser;
    }

    @Override
    public void deleteUser(int Id) {
        employeeRepo.deleteById(Id);
    }
}
