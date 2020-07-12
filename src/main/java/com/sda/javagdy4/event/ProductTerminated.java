package com.sda.javagdy4.event;

import com.sda.javagdy4.dispatcher.Dispatcher;
import com.sda.javagdy4.dispatcher.IEvent;
import com.sda.javagdy4.interfaces.ProductListener;

import java.util.List;

public class ProductTerminated implements IEvent {
    private Long id;

    public ProductTerminated(Long id) {
        this.id = id;
    }

    @Override
    public void execute() {
        List<ProductListener> productListeners = Dispatcher.getInstance().getAllObjectsImplementingInterface(ProductListener.class);
        for (ProductListener productListener : productListeners) {
            productListener.productRemoved(id);
        }
    }
}
