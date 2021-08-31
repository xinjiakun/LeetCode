package com.xin.singleton;

public class HungrySingleton {
	private static final HungrySingleton instance =  new HungrySingleton();
	public HungrySingleton() {}
	public static HungrySingleton getinstance() {
		return instance;
	}
}
