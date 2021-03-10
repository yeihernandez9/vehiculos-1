package com.vehiculos.demo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class THilo extends Thread{
	
	private static final Log logger = LogFactory.getLog(THilo.class);
	
	private int id;
	
	public THilo(int id) {
		
		this.id = id;
	}
	
	@Override
	public void run() {
		
	}
	
}
