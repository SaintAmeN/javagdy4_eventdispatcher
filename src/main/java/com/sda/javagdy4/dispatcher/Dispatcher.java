package com.sda.javagdy4.dispatcher;

import org.apache.commons.lang3.ClassUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispatcher {
    private static Dispatcher instance = new Dispatcher();

    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        return instance;
    }

    private Map<Class<?>, List<Object>> listeners = new HashMap<>();
    private ExecutorService threadpool = Executors.newSingleThreadExecutor();

    public void selfRegister(Object o) {
        List<Class<?>> interfaces = ClassUtils.getAllInterfaces(o.getClass());
        for (Class<?> anInterface : interfaces) {
            List<Object> objects;
            if (listeners.containsKey(anInterface)) {
                objects = listeners.get(anInterface);
            } else {
                objects = new ArrayList<>();
            }
            objects.add(o);
            listeners.put(anInterface, objects);
        }
    }

    public <T> List<T> getAllObjectsImplementingInterface(Class<T> tClass) {
        return (List<T>) listeners.get(tClass);
    }

    public void fireEvent(IEvent event) {
        threadpool.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    event.execute();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
