package com.lockTP.concurrent.concurrent2;

public class ConTest {

	public static void main(String[] args) {
		AddInt addInt1 = new AddInt("thread 1 ");
		AddInt addInt2 = new AddInt("thread 2 ");
		addInt1.start();
		addInt2.start();
	}
}
