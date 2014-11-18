package com.xabe.threadSafe.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainLock {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainLock.class);

	public static void main(String[] args) {
		
		LOGGER.info("Se crea 2 hilos");
		
		Lock lock = new ReentrantLock();
		Recurso recurso = new Recurso();
		
		for(int i=0; i < 2; i++){
			new Thread(new LockThread(lock, recurso), "Hilo_"+i).start();
		}
	}

}
