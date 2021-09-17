package com.ss.basics.deadlock;

/**
 * @author Matthew Hader
 *
 */
public class Deadlock {
	
	public static Object resource1 = new Object();
	public static Object resource2 = new Object();
	
	public static void main(String args[]) {
		
		Runnable thread1 = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized(resource1) {
						System.out.println("Thread one has resource 1");
						Thread.sleep(1000);
						synchronized(resource2) {
							System.out.println("Thread one has resource 1 and resource 2");
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable thread2 = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized(resource2) {
						System.out.println("Thread two has resource 2");
						Thread.sleep(1000);
						synchronized(resource1) {
							System.out.println("Thread two has resource 1 and resource 2");
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(thread1).start();
		new Thread(thread2).start();		
	}
}
