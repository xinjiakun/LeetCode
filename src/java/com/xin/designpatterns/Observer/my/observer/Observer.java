package com.xin.designpatterns.Observer.my.observer;

import com.xin.designpatterns.Observer.my.Subject;


public abstract class Observer {
    protected Subject subject;
    public abstract void updateData();
}
