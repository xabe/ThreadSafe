package com.xabe.threadSafe.volatileThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVolatile {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainVolatile.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Creamos 10 hilos");
		
		Contador contador = new Contador();
		
		for(int i=0; i < 10; i++){
			new Thread(new Hilo(contador), "Hilo_"+i).start();
		}
		
	}

}
