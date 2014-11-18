package com.xabe.threadSafe.semaphore;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainSemaphore {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainSemaphore.class);

	public static void main(String[] args) {
		
		LOGGER.info("Se crea 2 hilos");
		
		Semaphore semaphore = new Semaphore(1);
		Recurso recurso = new Recurso();
		
		for(int i=0; i < 2; i++){
			new Thread(new SemaphoreThread(semaphore, recurso), "Hilo_"+i).start();
		}
	}

}
