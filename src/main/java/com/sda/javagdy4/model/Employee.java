package com.sda.javagdy4.model;

import com.sda.javagdy4.departments.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String surname;
    private int age;
    private Department department;
}
