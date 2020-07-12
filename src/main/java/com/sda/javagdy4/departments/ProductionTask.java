package com.sda.javagdy4.departments;

import com.sda.javagdy4.interfaces.IMagazyn;
import com.sda.javagdy4.model.Product;

public class ProductionTask implements Runnable {
    private final Product product;
    private IMagazyn magazyn;

    public ProductionTask(Product product, IMagazyn magazyn) {
        this.product = product;
        this.magazyn = magazyn;
    }

    @Override
    public void run() {
        System.out.println("Wyprodukowano: " + product);
        magazyn.przyjetoNaStan(product);
    }
}
