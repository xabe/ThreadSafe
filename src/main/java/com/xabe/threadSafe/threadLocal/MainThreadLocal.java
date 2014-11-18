package com.xabe.threadSafe.threadLocal;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainThreadLocal {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainThreadLocal.class);
	
	public static void main(String[] args) throws InterruptedException {

		LOGGER.info("Crear 10 hilos para ver el uso de thread local");
		
		ThreadLocalUse threadLocalUse = new ThreadLocalUse();
		
        for(int i=0 ; i < 3; i++){
            Thread t = new Thread(threadLocalUse, "Hilo_" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

}
