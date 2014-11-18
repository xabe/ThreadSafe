package com.xabe.threadSafe.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LockThread implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LockThread.class);
	private Lock lock;
	private Recurso recurso;
	
	public LockThread(Lock lock,Recurso recurso) {
		this.lock = lock;
		this.recurso = recurso;
	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try
		{
			if(lock.tryLock(10, TimeUnit.SECONDS))
			{
				// Sección crítica a proteger
				LOGGER.info("Vamos hacer algo en el recurso en el " + name);
				recurso.hacerAlgo();
				Thread.sleep(new Random().nextInt(2000));
			}
		}catch(InterruptedException e){
			LOGGER.error(e.getMessage(),e);
		}
		finally{
			lock.unlock();
		}	
		LOGGER.info("Vamos hacer logging en el recurso en el " + name);
		recurso.hacerLogging();
		
	}
	

}
