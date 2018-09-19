package com.example.usb_host;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class detectManager {
	private final ThreadPoolExecutor threadPool;
	private final BlockingQueue<Runnable> workQueue;
	
	private static detectManager dm = null;
	private static mainThreadExecutor handler;
	    
	static {
		dm = new detectManager();
        handler = new mainThreadExecutor();
    }
	
	public static detectManager getDetectManager(){
        return dm;
    }
	
	public mainThreadExecutor getMainThreadExecutor(){
        return handler;
    }
	
	public detectManager() {
		// TODO Auto-generated constructor stub
		workQueue = new LinkedBlockingQueue<Runnable>();
		
		threadPool = new ThreadPoolExecutor(5, 5,
                50, TimeUnit.MILLISECONDS, workQueue);
	}

	public void runDetectionTask(Runnable task)
	{
		threadPool.execute(task);
	}
}
