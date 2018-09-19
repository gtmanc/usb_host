package com.example.usb_host;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private static final String TAG = MainActivity.class.getSimpleName();
	Context mContext = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "[onCreate] enter...");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContext = getApplicationContext();
		showDetectStatusTask sdst = new showDetectStatusTask(mContext);
		detectTask dt = new detectTask(mContext, sdst);
		detectManager.getDetectManager().runDetectionTask(dt);
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
}
