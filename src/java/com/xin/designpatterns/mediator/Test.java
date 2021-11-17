package com.xin.designpatterns.mediator;
public class Test {
	public static void main(String args[]){
		videoCourse videoCourse = new videoCourse();
		Midiator midiator = new Midiator();
		midiator.setVideoCourse(videoCourse);
		midiator.notifyOther(videoCourse);
	}
}