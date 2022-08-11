package com.nt.schedulling;


import java.util.TimerTask;

import org.hibernate.Session;

public class TimerService extends TimerTask {
	private Session ses;
	
	public TimerService(Session ses) {
		System.out.println("TimerService.TimerService()");
		this.ses = ses;
	}

	@Override
	public void run() {
		System.out.println("L1CacheEmptyService.run()");
		ses.clear();
		
	}

}
