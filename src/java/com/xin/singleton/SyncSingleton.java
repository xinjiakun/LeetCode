package com.xin.singleton;

public class SyncSingleton {
	private static SyncSingleton instance = null;
	private SyncSingleton() {}
	public synchronized static SyncSingleton getinstance() {
		if(instance == null) {
			instance = new SyncSingleton();
		}
		return instance;
	}
}
