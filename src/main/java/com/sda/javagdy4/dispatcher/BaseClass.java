package com.sda.javagdy4.dispatcher;

public abstract class BaseClass {
    public BaseClass() {
        Dispatcher.getInstance().selfRegister(this);
    }
}
