package com.xin.designpatterns.strategy;

public class Test {
    public static void main(String args[]) {
        Course saveData = new GraphicCourse();
        Client client = new Client(saveData);
        client.getCourse();
        client.setCourse(new videoCourse());
        client.getCourse();
    }
}