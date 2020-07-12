package com.sda.javagdy4.interfaces;

import com.sda.javagdy4.model.Product;

public interface ProductListener {
    void newProductLine(Product product);
    void productRemoved(Product product);
    void productRemoved(Long id);
    void productRelease(Long id);
}
