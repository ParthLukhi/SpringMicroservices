package com.project.departmentservice.repository;

import com.project.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRespository {
    private List<Department> departments = new ArrayList<>();

    public Department adddepartments(Department department){
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }
}
