package com.sda.javagdy4.event;

import com.sda.javagdy4.dispatcher.Dispatcher;
import com.sda.javagdy4.dispatcher.IEvent;
import com.sda.javagdy4.interfaces.ProductListener;
import com.sda.javagdy4.model.Product;

import java.util.List;

public class NewProductLine implements IEvent {
    private Product product;

    public NewProductLine(Product product) {
        this.product = product;
    }

    @Override
    public void execute() {
        List<ProductListener> productListeners = Dispatcher.getInstance().getAllObjectsImplementingInterface(ProductListener.class);
        for (ProductListener productListener : productListeners) {
            productListener.newProductLine(product);
        }
    }
}
