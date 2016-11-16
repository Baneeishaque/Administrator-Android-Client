package administrator.ui.pc;

import administrator.data.wbservice.Callerpower;
import administrator.ui.general.Home;
import android.androidVNC.Pchome;
import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Power extends Activity {

	public static String rslt = "";
	Callerpower c = new Callerpower();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.power);
	}

	public void shutdown(View v) {
		rslt = "START";
		c.action = "shut down";
		getresult();
		Intent target2 = new Intent(this, Home.class);
		startActivity(target2);
	}

	public void hibernate(View v) {
		rslt = "START";
		c.action = "hibernate";
		getresult();
		Intent target2 = new Intent(this, Home.class);
		startActivity(target2);
	}

	public void sleep(View v) {
		rslt = "START";
		c.action = "sleep";

		try {

			c.join();
			c.start();
			Toast.makeText(getApplicationContext(), "Sleep Success", Toast.LENGTH_LONG).show();
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();

		}
		Intent target2 = new Intent(this, Home.class);
		startActivity(target2);
	}

	public void log(View v) {
		rslt = "START";
		c.action = "log off";
		getresult();
		Intent target2 = new Intent(this, Pchome.class);
		startActivity(target2);
	}

	public void lock(View v) {
		rslt = "START";
		c.action = "lock";
		getresult();
		Intent target2 = new Intent(this, Pchome.class);
		startActivity(target2);
	}

	public void getresult() {
		try {

			c.join();
			c.start();
			while (rslt == "START") {
				try {
					Thread.sleep(10);

				} catch (Exception ex) {
					Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG).show();

				}
			}
			if (rslt.equals("shut down")) {
				Toast.makeText(getApplicationContext(), "Shut Down Success", Toast.LENGTH_LONG).show();

			} else {
				if (rslt.equals("hibernate")) {
					Toast.makeText(getApplicationContext(), "Hibernate Success", Toast.LENGTH_LONG).show();

				} else {
					if (rslt.equals("sleep")) {
						Toast.makeText(getApplicationContext(), "Sleep Success", Toast.LENGTH_LONG).show();

					} else {
						if (rslt.equals("log off")) {
							Toast.makeText(getApplicationContext(), "Log Off Success", Toast.LENGTH_LONG).show();

						} else {
							if (rslt.equals("lock")) {
								Toast.makeText(getApplicationContext(), "Lock Success", Toast.LENGTH_LONG).show();

							} else {
								Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG)
										.show();
							}
						}
					}
				}

			}

		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();

		}
	}

}
