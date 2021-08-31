package com.xin.singleton;

public class LazySingleton {
	private static LazySingleton instance = null;
	private LazySingleton() {}
	public static LazySingleton getinstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
