package com.xabe.threadSafe.synch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receptor implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receptor.class);
	private Mensaje msg;
    
    public Receptor(Mensaje msg){
        this.msg=msg;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try
            {
            	LOGGER.info(name+" esperando que llegue el mensaje");
                msg.wait();
            }catch(InterruptedException e){
                LOGGER.error(e.getMessage(), e);
            }
            LOGGER.info(name+" recibe el mensaje del emisor : "+msg.getMsg());
        }
    }

}
