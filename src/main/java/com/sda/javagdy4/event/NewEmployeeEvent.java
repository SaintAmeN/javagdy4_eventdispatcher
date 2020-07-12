package com.sda.javagdy4.event;

import com.sda.javagdy4.dispatcher.Dispatcher;
import com.sda.javagdy4.dispatcher.IEvent;
import com.sda.javagdy4.interfaces.NewEmployeeListener;
import com.sda.javagdy4.model.Employee;

import java.util.List;

public class NewEmployeeEvent implements IEvent {
    private Employee employee;

    public NewEmployeeEvent(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void execute() {
        List<NewEmployeeListener> listeners = Dispatcher.getInstance().getAllObjectsImplementingInterface(NewEmployeeListener.class);
        for (NewEmployeeListener listener : listeners) {
            listener.newEmployeeHired(employee);
        }

    }
}
