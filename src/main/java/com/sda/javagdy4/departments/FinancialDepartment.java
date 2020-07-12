package com.sda.javagdy4.departments;

import com.sda.javagdy4.dispatcher.BaseClass;
import com.sda.javagdy4.interfaces.NewEmployeeListener;
import com.sda.javagdy4.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class FinancialDepartment extends BaseClass implements NewEmployeeListener {
    private Map<Employee, Double> salaryMap = new HashMap<>();

    @Override
    public void newEmployeeHired(Employee employee) {
        salaryMap.put(employee, 1200d);
    }
}
