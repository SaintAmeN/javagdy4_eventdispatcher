package com.sda.javagdy4.departments;

import com.sda.javagdy4.dispatcher.BaseClass;
import com.sda.javagdy4.interfaces.IMagazyn;
import com.sda.javagdy4.interfaces.ProductListener;
import com.sda.javagdy4.model.Product;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ProductionDepartment extends BaseClass implements ProductListener, IMagazyn {
    private final Set<Product> productsToProduce = new HashSet<>();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    private Map<Product, Long> storageState = new HashMap<>();
    private List<ScheduledFuture> listaZadan = new ArrayList<>();

    @Override
    public void newProductLine(Product product) {
        System.out.println("New Product in production line.");
        productsToProduce.add(product);
    }

    @Override
    public void productRemoved(Product product) {
        System.out.println("Product removed from production line.");
        productsToProduce.remove(product);
    }

    @Override
    public void productRemoved(Long id) {
        productsToProduce.remove(new Product(id));
        for (ScheduledFuture future : listaZadan) {
            future.cancel(false);
        }
    }

    @Override
    public void productRelease(Long id) {
        Product releasedProduct = null;
        for (Product product : productsToProduce) {
            if (product.getId().equals(id)) {
                releasedProduct = product;
                break;
            }
        }
        if (releasedProduct != null) {
            ScheduledFuture future = scheduledExecutorService.scheduleAtFixedRate(new ProductionTask(releasedProduct, this), 0L, 5L, TimeUnit.SECONDS);
            listaZadan.add(future);
        }
    }

    @Override
    public void przyjetoNaStan(Product p) {
        if (storageState.containsKey(p)) {
            storageState.put(p, storageState.get(p) + 1); // zwieksz stan magazynu o 1, jesli ten produkt jest na magazynie
        } else {
            storageState.put(p, 1L);
        }
    }

    @Override
    public void zdjetoZeStanu(Product p) {
        if (storageState.containsKey(p)) {
            storageState.put(p, storageState.get(p) - 1); // zmniejsz stan magazynu o 1, jesli ten produkt jest na magazynie
        } else {
            storageState.put(p, 0L);
        }
    }
}
