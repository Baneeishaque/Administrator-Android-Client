package android.androidVNC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Connect extends Activity {

	EditText txtip;
	public static String ip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.connect);
		txtip = (EditText) findViewById(R.id.txtip);
	}

	public void next(View view) {
		ip = txtip.getEditableText().toString();
		Intent target = new Intent(this, Pchome.class);
		startActivity(target);

	}

}
