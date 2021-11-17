package com.xin.designpatterns.strategy;

/**
 * 视频课程
 */
public class videoCourse implements Course {
    @Override
    public void getCourse() {
        System.out.println(" 查询视频课程");
    }
}
