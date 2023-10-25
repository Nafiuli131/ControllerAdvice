package com.example.ControllerAdvice.controller;

import com.example.ControllerAdvice.dto.EmployeeDto;
import com.example.ControllerAdvice.entity.Employee;
import com.example.ControllerAdvice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
    }
}
