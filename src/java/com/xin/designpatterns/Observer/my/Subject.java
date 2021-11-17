package com.xin.designpatterns.Observer.my;


import com.xin.designpatterns.Observer.my.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {
    private List<Observer> observers = new ArrayList<>();
    private T data;

    public T getData() {
        return data;
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void setData(T data) {
        this.data = data;
        notifyOb();
    }

    public void notifyOb() {
        observers.forEach(Observer::updateData);
    }
}
