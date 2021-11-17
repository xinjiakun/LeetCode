package com.xin.designpatterns.Observer.my.observer;


import com.xin.designpatterns.Observer.my.Subject;

public class AObserver extends Observer {

    public AObserver(Subject subject) {
        this.subject = subject;
        subject.add(this);
    }

    @Override
    public void updateData() {
        System.out.println("AObserver: data:" + this.subject.getData());

    }
}
