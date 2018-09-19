package com.example.usb_host;

import java.util.HashMap;
import java.util.Iterator;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.util.Log;
import android.widget.Toast;

public class detectTask implements Runnable{
	Context mContext = null;
	UsbManager mManager = null;
	showDetectStatusTask mDetectStstusTask= null;
	mainThreadExecutor mMainExecutor = null;
	private static final String TAG = detectTask.class.getSimpleName();
	
	public detectTask(Context context, showDetectStatusTask sdst) {
		// TODO Auto-generated constructor stub
		mContext = context;
		mManager = (UsbManager) mContext.getSystemService(Context.USB_SERVICE);
		mDetectStstusTask = sdst;
		mMainExecutor = detectManager.getDetectManager().getMainThreadExecutor();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		HashMap<String, UsbDevice> deviceList = mManager.getDeviceList();
		Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
		
		while(true)
		{	
			if(deviceIterator.hasNext()){
				UsbDevice device = deviceList.get("deviceName");
				//Toast.makeText(mContext, device.getDeviceName(), Toast.LENGTH_LONG).show();
			}
			else
			{
				//try {
					Log.d(TAG, "No next!");
					//Toast t = Toast.makeText(mContext, "wait device...",Toast.LENGTH_LONG);
					
					//t.show();
					//Thread.sleep(10000);
				//} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mMainExecutor.execute(mDetectStstusTask);
		}
	}

}
