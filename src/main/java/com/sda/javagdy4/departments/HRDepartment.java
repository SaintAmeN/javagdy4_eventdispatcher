package com.sda.javagdy4.departments;

import com.sda.javagdy4.dispatcher.BaseClass;
import com.sda.javagdy4.interfaces.NewEmployeeListener;
import com.sda.javagdy4.model.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HRDepartment extends BaseClass implements NewEmployeeListener {
    private Set<Employee> employeeSet = new HashSet<>();

    @Override
    public void newEmployeeHired(Employee employee) {
        System.out.println("No nie... Znowu wiecej papierologii.");
        employeeSet.add(employee);
    }
}
