package com.xabe.threadSafe.threadLocal;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadLocalUse implements Runnable{
     
	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadLocalUse.class);
	
	@Override
	public void run() {
		
		LOGGER.info("Nombre del hilo= "+Thread.currentThread().getName()+" fecha al principio = "+DateThread.getDate());
        try 
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(),e);
        }
         
        DateThread.setDate(new Date());
         
        LOGGER.info("Nombre del hilo= "+Thread.currentThread().getName()+" fecha al final     = "+DateThread.getDate());
		
	}

}
 
