package com.xin.designpatterns.strategy;
public class Client {
	private Course course;
	public Client(Course course){
		this.course = course;
	}
	public void setCourse(Course course){
		this.course = course;
	}
	public void getCourse(){
		course.getCourse();
	}
}
