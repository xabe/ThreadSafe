package com.xabe.threadSafe.deadLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDeadLock {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainDeadLock.class);
	
	public static void main(String[] args) {		 
        final ResourceA a = new ResourceA();
        final ResourceB b = new ResourceB();
 
        // hilo 1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (a) { // synchronized (b) {
                    try {
                        // Añadimos un retardo para que ambos hilos puedan bloquear el mismo recurso
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    	LOGGER.error(e.getMessage(), e);
                    }
                    // el hilo 1 tiene A pero necesita B
                    synchronized (b) { // synchronized (a) {
                        LOGGER.info("In block 1");
                    }
                }
            }
        }; 
        
        
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (b) {
                    // hilo-2 tiene B pero tambien necesita A
                    synchronized (a) {
                    	 LOGGER.info("In block 2");
                    }
                }
            }
        };
 
        new Thread(block1).start();
        new Thread(block2).start();
	}

}
