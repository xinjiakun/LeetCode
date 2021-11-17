package com.xin.designpatterns.mymemento;


public class Memento<T> {
    private T originator;

    public Memento(T originator) {
        this.originator = originator;
    }

    public T getOriginator() {
        return originator;
    }
}
