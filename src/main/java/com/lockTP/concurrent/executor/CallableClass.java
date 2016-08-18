package com.lockTP.concurrent.executor;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<Integer>{

	private int i;
	
	public CallableClass(int i) {
		this.i = i;
	}
	
	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return i*2;
	}

}
