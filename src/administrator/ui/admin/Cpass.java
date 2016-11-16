package administrator.ui.admin;

import java.util.HashMap;

import administrator.data.DBController;
import administrator.ui.general.Home;
import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cpass extends Activity {

	private EditText txtuser;
	private EditText txtnpass;
	private EditText txtpass;
	String pass;
	DBController controller = new DBController(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cpass);

		txtuser = (EditText) findViewById(R.id.txtrpuser);
		txtnpass = (EditText) findViewById(R.id.txtrpnpass);
		txtpass = (EditText) findViewById(R.id.txtrppass);
	}

	public void check(View v) {
		HashMap<String, String> user = controller.getuser(txtuser.getText().toString());
		if (user.size() == 0) {

			Toast.makeText(this, "Unkonwn User", Toast.LENGTH_LONG).show();

		} else {
			pass = user.get("password");

			if (txtpass.getText().toString().equals(pass)) {
				if (txtnpass.getText().toString().isEmpty()) {
					Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_LONG).show();

				} else {
					if (txtnpass.getText().toString().length() < 6) {
						Toast.makeText(this, "Minimum length is 6", Toast.LENGTH_LONG).show();
					} else {
						HashMap<String, String> queryValues = new HashMap<String, String>();

						queryValues.put("username", txtuser.getText().toString());
						queryValues.put("password", txtnpass.getText().toString());

						controller.updatepass(queryValues);

						Toast.makeText(this, "Password changed successfully", Toast.LENGTH_LONG).show();

						Intent target = new Intent(this, Home.class);
						startActivity(target);

					}
				}

			} else {
				Toast.makeText(this, "Unkonwn Password", Toast.LENGTH_LONG).show();
			}

		}
	}

}
