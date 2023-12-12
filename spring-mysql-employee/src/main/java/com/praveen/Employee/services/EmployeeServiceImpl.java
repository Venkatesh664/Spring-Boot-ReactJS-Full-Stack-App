package com.praveen.Employee.services;

import com.praveen.Employee.entity.EmployeeEntity;
import com.praveen.Employee.model.Employee;
import com.praveen.Employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity); // copy all values from emplyee and pass to emplyeeEntity

        employeeRepository.save(employeeEntity);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        //get list of employee entity from repository
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

//        converting list of employee entity to list of employee
        List<Employee> employees = employeeEntities.stream().map(emp-> new Employee(emp.getId(), emp.getFirstname(), emp.getLastname(), emp.getEmailId())).collect(Collectors.toList());

        return employees;
    }

//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

//    @Override
//    public void deleteById(Long id) {
//        employeeRepository.deleteById(id);
//    }
//    @Override
//    public EmployeeEntity updateEmployee(Long id, String firstname, String lastname, String emailId){
//        EmployeeEntity employeeEntity = employeeRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Employee with id "+id+" not found"));
//
//        employeeEntity.setFirstName(firstname);
//        employeeEntity.setLastName(lastname);
//        employeeEntity.setEmailid(emailId);
//
//        return employeeRepository.save(employeeEntity);
//    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id "+id+" not found"));
        Employee employee = new Employee();
        //copy all properties from employeeEntity to employee
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setFirstname(employee.getFirstname());
        employeeEntity.setEmailId(employee.getEmailId());
//        employeeEntity.setFirstname(employee.getFirstname());
        employeeEntity.setLastname(employee.getLastname());

        employeeRepository.save(employeeEntity);
        return employee;
    }
}
