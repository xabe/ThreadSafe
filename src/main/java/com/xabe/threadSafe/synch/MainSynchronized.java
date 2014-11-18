package com.xabe.threadSafe.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainSynchronized {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainSynchronized.class);
	
	public static void main(String[] args) {		 
		
		Mensaje msg = new Mensaje("mensaje");
		
        Receptor receptor1 = new Receptor(msg);
        new Thread(receptor1,"Receptor 1").start();
         
        Receptor receptor2 = new Receptor(msg);
        new Thread(receptor2, "Receptor 2").start();
         
        Emisor emisor = new Emisor(msg);
        new Thread(emisor, "Emisor").start();
        
        LOGGER.info("Arrancado todos los hilos");
		
	}

}
