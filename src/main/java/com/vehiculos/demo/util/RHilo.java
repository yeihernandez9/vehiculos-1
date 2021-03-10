package com.vehiculos.demo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RHilo implements Runnable {
	private static final Log logger = LogFactory.getLog(THilo.class);
	
	private int id;
	
	public RHilo(int id) {
		
		this.id = id;
	}
	
	@Override
	public void run() {
		
	}
}
