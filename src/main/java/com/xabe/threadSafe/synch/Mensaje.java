package com.xabe.threadSafe.synch;

public class Mensaje {
	
	private String msg;
	
	public Mensaje() {
		this.msg = "";
	}
    
    public Mensaje(String str){
        this.msg=str;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String str) {
        this.msg=str;
    }

}
