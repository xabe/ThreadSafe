package com.xabe.threadSafe.deadLock;

public class ResourceB {
	 private int i = 20;
	 
     public int getI() {
         return i;
     }

     public void setI(int i) {
         this.i = i;
     }
}
