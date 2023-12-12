package com.praveen.Employee.services;

import com.praveen.Employee.entity.EmployeeEntity;
import com.praveen.Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

//    void deleteById(Long id);

//    EmployeeEntity updateEmployee(Long id, String firstname, String lastname, String emailId);

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
