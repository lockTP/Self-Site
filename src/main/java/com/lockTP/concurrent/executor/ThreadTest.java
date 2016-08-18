package com.lockTP.concurrent.executor;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest extends Thread{
	private final AtomicInteger i = new AtomicInteger();
	
	@Override
	public void run() {
		
		try {
			ThreadTest.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i.incrementAndGet();
		System.out.println("ThreadTest is running! i = " + i);
	}

}
