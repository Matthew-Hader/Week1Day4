package com.ss.basics.prodcon;

import java.util.LinkedList;

/**
 * @author Matthew Hader
 *
 */
public class ProducerConsumer {
	
	LinkedList<Integer> buffer = new LinkedList<>();
	int maxBuffer = 3;
	
	public static void main(String args[]) {
		
		ProducerConsumer pc = new ProducerConsumer();
		
		Runnable producer = new Runnable() {

			@Override
			public void run() {
				
				try {
					pc.produce();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				
				try {
					pc.consume();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}
	
	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
			synchronized(this) {
				while(buffer.size() == maxBuffer) {
					wait();
				}
				//Space exists in buffer, so produce
				System.out.printf("Producer has produced: %d\n", value);
				buffer.add(value++);
				
				//Wake up consumer
				notify();
				
				Thread.sleep(1000);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(this) {
				while(buffer.size() == 0) {
					wait();
				}
				
				//Items exist in buffer, so consume
				int consumed = buffer.removeFirst();
				System.out.printf("Consumer has consumed: %d\n", consumed);
				
				//Wake up producer
				notify();
				
				Thread.sleep(1000);
			}
		}
	}
}
