package com.example.usb_host;

import java.util.HashMap;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	Context mContext = getApplicationContext();
	UsbManager mManager = (UsbManager) mContext.getSystemService(Context.USB_SERVICE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent i = new Intent();
		i.setClass(mContext, detection.class);
		//mContext.startService(i);
		detection.run();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}




	private Runnable detection = new Runnable(){
		@Override
	    public void run() {
			while(true)
			{
				HashMap<String, UsbDevice> deviceList = mManager.getDeviceList();
				Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
				if(deviceIterator.hasNext()){
					UsbDevice device = deviceList.get("deviceName");
					Toast.makeText(mContext, device.getDeviceName(), Toast.LENGTH_LONG).show();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
		
	};
}
