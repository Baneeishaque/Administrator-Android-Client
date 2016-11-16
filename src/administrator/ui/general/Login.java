package administrator.ui.general;

import java.util.HashMap;

import administrator.data.DBController;
import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	private EditText txtuser;
	private EditText txtpass;
	String pass;

	DBController controller = new DBController(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtuser = (EditText) findViewById(R.id.txtluser);
		txtpass = (EditText) findViewById(R.id.txtlpass);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
			startActivity(intent);
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {

	}

	public void next(View view) {

		HashMap<String, String> user = controller.getuser(txtuser.getText().toString());
		if (user.size() == 0) {

			Toast.makeText(this, "Unkonwn User", Toast.LENGTH_LONG).show();

		} else {
			pass = user.get("password");

			if (txtpass.getText().toString().equals(pass)) {

				Intent target = new Intent(this, Home.class);
				startActivity(target);

			} else {
				Toast.makeText(this, "Unkonwn User", Toast.LENGTH_LONG).show();
			}

		}

	}

}