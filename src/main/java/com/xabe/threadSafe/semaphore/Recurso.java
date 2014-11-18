package com.xabe.threadSafe.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Recurso {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Recurso.class);
	
	public void hacerAlgo(){
        LOGGER.info("Estamos haciendo algo en el recurso");
    }
     
    public void hacerLogging(){
    	 LOGGER.info("Estamos haciendo logging en el recurso");
    }

}
