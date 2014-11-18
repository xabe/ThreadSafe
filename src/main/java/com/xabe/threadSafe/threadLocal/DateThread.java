package com.xabe.threadSafe.threadLocal;

import java.util.Date;

public class DateThread {
	
	private static ThreadLocal<Date> dateThread = new ThreadLocal<Date>() {
		//Inicializamos con un valor
		protected Date initialValue() {
			return new Date();
		}
	};
	
	public static void setDate(Date date){
		dateThread.set(date);
	}
	
	public static Date getDate(){
		return dateThread.get();
	}

}
