package com.xabe.threadSafe.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SemaphoreThread implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SemaphoreThread.class);
	private Semaphore semaphore;
	private Recurso recurso;
	
	public SemaphoreThread(Semaphore semaphore,Recurso recurso) {
		this.semaphore = semaphore;
		this.recurso = recurso;
	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try
		{
			semaphore.acquire();

			// Sección crítica a proteger
			LOGGER.info("Vamos hacer algo en el recurso en el " + name);
			recurso.hacerAlgo();

			Thread.sleep(new Random().nextInt(2000));
		}catch(InterruptedException e){
			LOGGER.error(e.getMessage(),e);
		}
		finally{
			semaphore.release();
		}	
		LOGGER.info("Vamos hacer logging en el recurso en el " + name);
		recurso.hacerLogging();
		
	}
	

}
