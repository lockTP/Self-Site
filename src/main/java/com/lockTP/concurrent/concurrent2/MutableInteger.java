package com.lockTP.concurrent.concurrent2;

public class MutableInteger {
	private int value;
	public int get(){
		return value;
	}
	public void set(int value){
		this.value = value;
	}
}