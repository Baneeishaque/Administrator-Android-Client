package administrator.ui.general;

import administrator.ui.admin.Cpass;
import android.androidVNC.Connect;
import android.androidVNC.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RemoteViews;

public class Home extends Activity {
	public static final int admin = 0;
//	private static final String TAG = "Administartor Android Client";
	/** Identifier for the notification. */
	private static int NOTIF_ID = 'S' << 24 + 'd' << 16 + 'k' << 8 + 'C' << 0;
	NotificationManager nm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent home_intent = new Intent(this, Home.class);
		home_intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent pi = PendingIntent.getActivity(this, // context
				0, // requestCode
				home_intent, // intent
				0 // pending intent flags
		);
		
		
		
		NotificationCompat.Builder mBuilder =
			    new NotificationCompat.Builder(this)
			    .setSmallIcon(R.drawable.launcher)
			    .setContentTitle("Administartor")
			    .setContentText("Administrator is Active")
			    .setContentIntent(pi); //Required on Gingerbread and below
		
		Notification n =mBuilder.build();
		n.flags |= Notification.FLAG_ONGOING_EVENT | Notification.FLAG_NO_CLEAR;
		
		nm.notify(NOTIF_ID, n);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		menu.add(0, admin, 0, R.string.mithome);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getOrder()) {

		case 100:

			Intent target3 = new Intent(this, Habout.class);
			startActivity(target3);
			return true;

		case 200:

			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			nm.cancel(NOTIF_ID);
			startActivity(intent);
			return true;

		}
		switch (item.getItemId()) {
		case admin:

			Intent target = new Intent(this, Cpass.class);
			startActivity(target);
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	public void connect(View view) {
		Intent target = new Intent(this, Connect.class);
		startActivity(target);
	}

	public void network(View view) {
		
		startActivity(new Intent(Settings.ACTION_SETTINGS));
	}

	@Override
	public void onBackPressed() {

	}

//	@Override
//	protected void onStop() {
//	    Log.w(TAG, "App stopped");
//	    super.onStop();
//	}
//
//	@Override
//	protected void onDestroy() {
//	    Log.w(TAG, "App destroyed");
//	    super.onDestroy();
//	}
	
	

}
