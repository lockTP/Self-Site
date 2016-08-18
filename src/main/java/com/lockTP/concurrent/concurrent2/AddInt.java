package com.lockTP.concurrent.concurrent2;

public class AddInt extends Thread{
	private String thrString;
	public AddInt(String thrString){
		this.thrString = thrString;
	}
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread:"+thrString+" is running "+i);
		}
	}
}
