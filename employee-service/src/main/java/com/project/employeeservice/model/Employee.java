package com.project.employeeservice.model;

public record Employee(Long id, Long departmentId, String name, int agep, String position) {
}
