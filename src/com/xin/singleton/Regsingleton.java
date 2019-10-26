package com.xin.singleton;

import java.util.HashMap;

public class Regsingleton {
	private  static HashMap registry =  new HashMap();
	static {
		Regsingleton regsingleton = new Regsingleton();
		registry.put(regsingleton.getClass().getName(), regsingleton);
	}
	protected Regsingleton() {}
	public static Regsingleton getInstance(String name) {
		if(name == null) {
			name = "RegSingleton ";
		}
		if (registry.get(name) == null) {
			try {
				registry.put(name, Class.forName(name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return (Regsingleton)registry.get(name);
	}
}
