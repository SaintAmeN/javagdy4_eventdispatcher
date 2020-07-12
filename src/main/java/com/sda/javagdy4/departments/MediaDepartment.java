package com.sda.javagdy4.departments;

import com.sda.javagdy4.dispatcher.BaseClass;
import com.sda.javagdy4.interfaces.NewEmployeeListener;
import com.sda.javagdy4.interfaces.ProductListener;
import com.sda.javagdy4.model.Employee;
import com.sda.javagdy4.model.Product;

public class MediaDepartment extends BaseClass implements NewEmployeeListener, ProductListener {
    @Override
    public void newEmployeeHired(Employee employee) {
        System.out.println("O! tosie fote cyknie i na stronke!");
    }

    @Override
    public void newProductLine(Product product) {
        System.out.println("O super se boszure zrobimy!");
    }

    @Override
    public void productRemoved(Product product) {
        System.out.println("Onie.");
    }

    @Override
    public void productRemoved(Long id) {
        System.out.println("Onienie.");
    }

    @Override
    public void productRelease(Long id) {

    }
}
