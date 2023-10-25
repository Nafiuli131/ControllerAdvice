package com.example.ControllerAdvice.service;

import com.example.ControllerAdvice.dto.EmployeeDto;
import com.example.ControllerAdvice.entity.Employee;
import com.example.ControllerAdvice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee saveEmployee(EmployeeDto employeeDto){
        return convertDtoToEntity(employeeDto);
    }

    private Employee convertDtoToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employeeRepository.save(employee);
        return employee;
    }
    private EmployeeDto convertEntityToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeList.forEach(e->{
            employeeDtoList.add(convertEntityToDto(e));
        });
        return employeeDtoList;
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

}
