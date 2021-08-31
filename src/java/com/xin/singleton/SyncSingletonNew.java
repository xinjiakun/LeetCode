package com.xin.singleton;

public class SyncSingletonNew {
	private static SyncSingletonNew instance = null;
	private SyncSingletonNew() {}
	public static SyncSingletonNew getinstance() {
		synchronized(SyncSingletonNew.class) {
			if(instance == null) {
				instance = new SyncSingletonNew();
			}		
		}
		return instance;
	}
}
