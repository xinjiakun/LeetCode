package com.xin.designpatterns.mymemento;


public class Originator<T> {
    private T data;
    Originator(T data){
        this.data=data;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public Memento<T> saveDataToMemento(){
        return new Memento<T>(data);
    }

    public void getDataFromMemento(Memento<T> Memento){
        data = (T)Memento.getOriginator();
    }
}
