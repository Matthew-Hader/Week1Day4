package com.ss.basics.singleton;

/**
 * @author Matthew Hader
 *
 */
public class Singleton {

	private volatile static Singleton instance;
	
	//Private default constructor
	private Singleton() {
		
	}
	
	//Public instance to allow access to singleton
	public Singleton getInstance() {
		
		//Check if instances exists
		if(instance == null) {
			//Instance does not exist, so a thread must make one
			synchronized(Singleton.class) {
				//Double-checking instance before making one
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
