package com.project.departmentservice.controller;

import com.project.departmentservice.client.EmployeeClient;
import com.project.departmentservice.model.Department;
import com.project.departmentservice.model.Employee;
import com.project.departmentservice.repository.DepartmentRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRespository respository;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return respository.adddepartments(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return respository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find: id={}", id);
        return respository.findById(id);
    }

    @GetMapping("/with-employee")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department find");
       List<Department> departments = respository.findAll();
       departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
       return departments;
    }
}
