package com.xin.designpatterns.mediator;
/**
 *中介者
 */
public class Midiator {
	videoCourse videoCourse;
	public Midiator setVideoCourse(videoCourse videoCourse) {
		this.videoCourse = videoCourse;
		return this;
	}
	public void notifyOther(Course course){
		if(course instanceof videoCourse)
			videoCourse.getCourse();
	}
}
