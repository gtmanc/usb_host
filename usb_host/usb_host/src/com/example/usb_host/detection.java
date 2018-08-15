package com.example.usb_host;

import java.util.HashMap;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.IBinder;

public class detection extends Service{
	
	detection(Context context)
	{
		UsbManager manager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
		
		HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
		UsbDevice device = deviceList.get("deviceName");
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void onCreate()
	{
	}
	
	public void onStartCommand(Intent intent)
	{
	}
}
