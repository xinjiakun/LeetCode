package com.xin.singleton;

public class DoubleSyncSingeton {
	private static volatile DoubleSyncSingeton singleton;
	private DoubleSyncSingeton() {}
	public static DoubleSyncSingeton getInstance() {
		if(singleton == null) {
			synchronized (DoubleSyncSingeton.class) {
				if(singleton == null) {
					singleton = new DoubleSyncSingeton();
				}
			}
		}
		return singleton;
	}
}
