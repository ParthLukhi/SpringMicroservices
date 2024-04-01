package com.project.employeeservice.controller;

import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository respository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add {}", employee);
        return respository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee find");
        return respository.findAll();
    }

    @GetMapping("/{id}")

    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("Employee find: id={}", id);
        return respository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employee find: departmentId={}",departmentId);
        return respository.findByDepartment(departmentId);
    }
}
