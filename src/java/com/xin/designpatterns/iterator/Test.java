package com.xin.designpatterns.iterator;


public class Test {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator =list.getIterator();
        while ( iterator.hasNext()){
            System.out.println(iterator.Next());
        }
    }
}
