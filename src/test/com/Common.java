package com;

public class Common {
	
	public static void waitSec(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			System.out.println("cannot sleep");
		}
	}
	

}
