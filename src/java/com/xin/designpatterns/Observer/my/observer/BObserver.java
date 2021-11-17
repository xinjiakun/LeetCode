package com.xin.designpatterns.Observer.my.observer;


import com.xin.designpatterns.Observer.my.Subject;

public class BObserver extends Observer {

    public BObserver(Subject subject) {
        this.subject = subject;
        subject.add(this);
    }

    @Override
    public void updateData() {
        System.out.println("BObserver: data:" + this.subject.getData());
    }
}
