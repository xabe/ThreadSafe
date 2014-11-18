package com.xabe.threadSafe.deadLock;

public class ResourceA {
	 private int i = 10;
	 
     public int getI() {
         return i;
     }

     public void setI(int i) {
         this.i = i;
     }

}
