package com.example.usb_host;

import android.content.Context;
import android.widget.Toast;

public class showDetectStatusTask implements Runnable{
	Context mContext = null;
	String mMessage = null;
	
	public showDetectStatusTask(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	public void setMsg(String msg){
		mMessage = msg;
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Toast.makeText(mContext, device.getDeviceName(), Toast.LENGTH_LONG).show();
		Toast.makeText(mContext, "====Run====", Toast.LENGTH_LONG).show();
	}

}
