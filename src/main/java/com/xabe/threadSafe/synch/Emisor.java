package com.xabe.threadSafe.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Emisor implements Runnable {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(Emisor.class);
    private Mensaje msg;
     
    public Emisor(Mensaje msg) {
        this.msg = msg;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        LOGGER.info(name+" empizar el emisor");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" he terminado mi trabajo ");
                LOGGER.info("Emisor ha terminado");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
        	LOGGER.error(e.getMessage(),e);
        }
         
    }
 
}
