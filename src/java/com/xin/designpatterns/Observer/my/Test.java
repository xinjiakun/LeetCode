package com.xin.designpatterns.Observer.my;


import com.xin.designpatterns.Observer.my.observer.AObserver;
import com.xin.designpatterns.Observer.my.observer.BObserver;

public class Test {
    public static void main(String[] args) {
        Subject<String> subject= new Subject<>();
        AObserver aObserver =new AObserver(subject);
        BObserver bObserver =new BObserver(subject);
        subject.setData("xxx");
    }
}
