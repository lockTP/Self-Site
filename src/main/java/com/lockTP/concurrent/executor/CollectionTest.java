package com.lockTP.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollectionTest{
	private static final int NTHREADS = 250;
	private static final ExecutorService executorTest = Executors.newFixedThreadPool(NTHREADS);
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		for (int i = 0; i < list.size(); i++) {
			futures.add(executorTest.submit(new CallableClass(list.get(i))));
		}
		
		for(Future<Integer> future : futures){
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
