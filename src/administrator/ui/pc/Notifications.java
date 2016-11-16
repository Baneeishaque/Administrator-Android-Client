package administrator.ui.pc;

import administrator.data.wbservice.Callermessage;
import android.androidVNC.Pchome;
import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Notifications extends Activity {

	private EditText txtsubject;
	private EditText txtmessage;
	public static String rslt = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notifications);

		txtsubject = (EditText) findViewById(R.id.txtsubject);
		txtmessage = (EditText) findViewById(R.id.txtmessage);
	}

	public void next(View view) {
		String s = txtsubject.getEditableText().toString();
		String m = txtmessage.getEditableText().toString();

		if (txtsubject.getText().toString().isEmpty()) {
			Toast.makeText(this, "Subject cannot be empty", Toast.LENGTH_LONG).show();

		} else {
			if (txtmessage.getText().toString().isEmpty()) {
				Toast.makeText(this, "Message cannot be empty", Toast.LENGTH_LONG).show();
			} else {

				try {
					rslt = "START";
					Callermessage c = new Callermessage();
					c.subject = s;
					c.message = m;
					c.join();
					c.start();
					while (rslt == "START") {
						try {
							Thread.sleep(10);

						} catch (Exception ex) {
							Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG).show();

						}
					}
					if (rslt.equals("ok")) {

						Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
						Intent target = new Intent(this, Pchome.class);
						startActivity(target);

					} else {
						Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG).show();

					}

				} catch (Exception ex) {
					Toast.makeText(getApplicationContext(), "Communication Error", Toast.LENGTH_LONG).show();

					Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();

				}
			}
		}
	}

}
