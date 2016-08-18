package com.lockTP.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest implements Executor{
	
	private static final int NTHREADS = 250;
	private static final ExecutorService executorTest = Executors.newFixedThreadPool(NTHREADS);
	
	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		int i;
		for (i = 0; i < 1000; i++) {
			executorTest.execute(threadTest);
		}
		if(i == 1000) executorTest.shutdown();
	}
	@Override
	public void execute(Runnable runnable) {
		// TODO Auto-generated method stub
		new Thread(runnable).start();
	}
	
}
