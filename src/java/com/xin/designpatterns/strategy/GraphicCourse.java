package com.xin.designpatterns.strategy;

/**
 * 图文课程
 */
public class GraphicCourse implements Course {
    @Override
    public void getCourse() {
        System.out.println("查询图文课程 ");
    }
}