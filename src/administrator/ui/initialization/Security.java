package administrator.ui.initialization;

import java.util.HashMap;

import administrator.data.DBController;
import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Security extends Activity {
	private EditText txtuser;
	private EditText txtpass;
	private EditText txtcpass;
	DBController controller = new DBController(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.security);

		txtuser = (EditText) findViewById(R.id.txtuser);
		txtpass = (EditText) findViewById(R.id.txtpass);
		txtcpass = (EditText) findViewById(R.id.txtcpass);

	}

	public void check(View view) {

		if (txtuser.getText().toString().isEmpty()) {
			Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_LONG).show();

		} else {
			if (txtuser.getText().toString().length() < 8) {
				Toast.makeText(this, "Minimum length is 8", Toast.LENGTH_LONG).show();
			} else {

				if (txtpass.getText().toString().isEmpty()) {
					Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_LONG).show();
				} else {
					if (txtpass.getText().toString().length() < 6) {
						Toast.makeText(this, "Minimum length is 6", Toast.LENGTH_LONG).show();
					} else {
						if (txtpass.getEditableText().toString().equals(txtcpass.getEditableText().toString())) {

							HashMap<String, String> queryValues = new HashMap<String, String>();
							queryValues.put("username", txtuser.getText().toString());
							queryValues.put("password", txtpass.getText().toString());
							controller.insertdb(queryValues);

							Intent target = new Intent(this, Done.class);
							startActivity(target);
						} else {
							Toast.makeText(this, "Passwords deosn't match,try again", Toast.LENGTH_LONG).show();

						}
					}
				}
			}
		}
	}

}