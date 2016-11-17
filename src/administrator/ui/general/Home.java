package administrator.ui.general;

import administrator.global.Project_Data;
import administrator.ui.admin.Cpass;
import android.androidVNC.Connect;
import android.androidVNC.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Home extends Activity {
	public static final int admin = 0;
	// private static final String TAG = "Administartor Android Client";
	/** Identifier for the notification. */

	NotificationManager nm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		give_unclear_notification(this.getClass(), R.drawable.launcher, "Administartor", "Administrator is Active",
				Project_Data.NOTIF_ID);

	}

	public void give_unclear_notification(Class pending_class, int notification_icon, String notification_title,
			String notification_text, int notification_id) {
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent pending_activity = new Intent(this, pending_class);
		pending_activity.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent pending_indent = PendingIntent.getActivity(this, // context
				0, // requestCode
				pending_activity, // intent
				0 // pending intent flags
		);

		NotificationCompat.Builder ncBuilder = new NotificationCompat.Builder(this).setSmallIcon(notification_icon)
				.setContentTitle(notification_title).setContentText(notification_text).setContentIntent(pending_indent); // Required
																															// on
																															// Gingerbread
																															// and
																															// below

		Notification n = ncBuilder.build();
		n.flags |= Notification.FLAG_ONGOING_EVENT | Notification.FLAG_NO_CLEAR;

		nm.notify(notification_id, n);
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
			nm.cancel(Project_Data.NOTIF_ID);
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

		Intent settings_indent=new Intent(Settings.ACTION_SETTINGS);
		settings_indent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(settings_indent);
	}

	@Override
	public void onBackPressed() {

	}

	// @Override
	// protected void onStop() {
	// Log.w(TAG, "App stopped");
	// super.onStop();
	// }
	//
	// @Override
	// protected void onDestroy() {
	// Log.w(TAG, "App destroyed");
	// super.onDestroy();
	// }

}
