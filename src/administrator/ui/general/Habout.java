package administrator.ui.general;

import administrator.global.Project_Data;
import android.androidVNC.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.webkit.WebView;

public class Habout extends Activity {

	NotificationManager nm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.habout);
		
		give_unclear_notification(this.getClass(), R.drawable.launcher, "Administartor", "Administrator is Active",
				Project_Data.NOTIF_ID);

		WebView wv = (WebView) findViewById(R.id.wbvwabout);
		wv.loadUrl("file:///android_asset/about.html");

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
}
