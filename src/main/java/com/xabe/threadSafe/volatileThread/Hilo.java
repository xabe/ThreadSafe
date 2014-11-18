package com.xabe.threadSafe.volatileThread;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hilo implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Hilo.class);
	private Contador contador;
    
    public Hilo(Contador contador){
        this.contador=contador;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        LOGGER.info(name+" el valor de contador es : "+contador.getCounter());
        contador.aumentar();
        LOGGER.info(name+" Aumentado el contador");
        try
        {
        	Thread.sleep(new Random().nextInt(2000));
        }catch(InterruptedException e){
        	LOGGER.error(e.getMessage(),e);
        }
        contador.aumentar();
        LOGGER.info(name+" Aumentado el contador su valor es : "+contador.getCounter());
    }

}
