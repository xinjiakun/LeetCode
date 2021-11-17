package com.xin.designpatterns.iterator;


public class ArrayList<T> implements List<T> {
    private int size;
    private Object[] dataList=new Object[10];

    @Override
    public Iterator getIterator() {
        return new ArrayListIterator();
    }

    @Override
    public boolean add(T t) {
        dataList[size++]=t;
        return false;
    }

    class ArrayListIterator<T> implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T Next() {
            if (hasNext()) {
                return (T)dataList[index++];
            }
            return null;
        }
    }
}
