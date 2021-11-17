package com.xin.designpatterns.iterator;


public interface List<T> {
    Iterator getIterator();
    boolean add(T t);
}
