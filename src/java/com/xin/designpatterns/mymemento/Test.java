package com.xin.designpatterns.mymemento;


public class Test {
    public static void main(String[] args) {
        CareTaker careTaker =new CareTaker();
        Originator<String> originator=new Originator("xxxx1");
        careTaker.add(originator.saveDataToMemento());
        originator.setData("xxxx2");
        careTaker.add(originator.saveDataToMemento());
        originator.setData("xxxx3");
        careTaker.add(originator.saveDataToMemento());
        System.out.println( originator.getData());
        originator.getDataFromMemento(careTaker.get(0));
        System.out.println( originator.getData());
        originator.getDataFromMemento(careTaker.get(1));
        System.out.println( originator.getData());
    }
}
