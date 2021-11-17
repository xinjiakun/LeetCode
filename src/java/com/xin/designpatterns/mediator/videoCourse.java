package com.xin.designpatterns.mediator;
public class videoCourse implements Course {
	@Override
	public void getCourse() {
		System.out.println("获取视频课程");
	}
}
