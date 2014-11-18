package com.xabe.threadSafe.volatileThread;

public class Contador {
	
	 private volatile int counter = 0;
	 
	 public void aumentar() {
		counter++;
	}
	 
	 public int getCounter() {
		return counter;
	}

}
