package android.androidVNC;

import java.util.ArrayList;

import administrator.ui.general.Habout;
import administrator.ui.general.Home;
import administrator.ui.pc.Notifications;
import administrator.ui.pc.Power;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Pchome extends Activity {

	public static final int test = 0;
	private ConnectionBean selected;
	Connect c = new Connect();

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pchome);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		menu.add(0, test, 0, "Test Connection");
		return true;
	}

	@Override
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
			startActivity(intent);
			return true;
		}
		switch (item.getItemId()) {
		case test:
			String url = "http://" + Connect.ip + "/";
			Intent target = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			startActivity(target);
			return true;

		}

		return super.onOptionsItemSelected(item);
	}

	public void desk(View view) {
		if (selected == null)
			return;
		updateSelectedFromView();
		Intent intent = new Intent(this, VncCanvasActivity.class);
		intent.putExtra("android.androidVNC.CONNECTION", selected.Gen_getValues());
		startActivity(intent);
	}

	private void updateSelectedFromView() {
		if (selected == null) {
			return;
		}
		selected.setAddress(Connect.ip);

	}

	protected void onStart() {
		super.onStart();
		arriveOnPage();
	}

	void arriveOnPage() {
		ArrayList<ConnectionBean> connections = new ArrayList<ConnectionBean>();
		connections.add(0, new ConnectionBean());
		selected = connections.get(0);

	}

	public void not(View view) {
		Intent target = new Intent(this, Notifications.class);
		startActivity(target);
	}

	public void dis(View view) {
		Intent target = new Intent(this, Home.class);
		startActivity(target);
	}

	public void pow(View view) {
		Intent target = new Intent(this, Power.class);
		startActivity(target);
	}

	@Override
	public void onBackPressed() {

	}

}
