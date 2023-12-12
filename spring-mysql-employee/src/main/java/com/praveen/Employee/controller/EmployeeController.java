package com.praveen.Employee.controller;

import com.praveen.Employee.entity.EmployeeEntity;
import com.praveen.Employee.model.Employee;
import com.praveen.Employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/getEmployees")
//    public List<EmployeeEntity> getAllEmployees(){
//        return employeeService.getAllEmployees();
//    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean delete = false;
        delete = employeeService.deleteEmployee(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("deleted", delete);
        return ResponseEntity.ok(map);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
//        employeeService.deleteById(id);
//        return ResponseEntity.ok("Employee with "+id+" is deleted");
//    }

//    @PostMapping("/{id}")
//    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String emailId){
//        EmployeeEntity employeeEntity = employeeService.updateEmployee(id, firstname, lastname, emailId);
//        return ResponseEntity.ok(employeeEntity);
//    }

        //update employee
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee= null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }

}
