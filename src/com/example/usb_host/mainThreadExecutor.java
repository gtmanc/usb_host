package com.example.usb_host;

import java.util.concurrent.Executor;

import android.os.Handler;
import android.os.Looper;

public class mainThreadExecutor implements Executor{

	public mainThreadExecutor() {
		// TODO Auto-generated constructor stub
	}

	private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
