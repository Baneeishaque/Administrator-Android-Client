package administrator.ui.initialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import administrator.ui.general.Login;
import android.androidVNC.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Done extends Activity {

	View v;
	FileOutputStream fos;
	int i;
	int s = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.done);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (i = 0; i < 2; i++) {

						Thread.sleep(1000);

					}
					next(v);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void next(View view) {
		String FILE = "ini";

		try {

			fos = openFileOutput(FILE, Context.MODE_PRIVATE);
			try {
				fos.write(s);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
		}
		Intent target = new Intent(this, Login.class);
		startActivity(target);
	}

	@Override
	public void onBackPressed() {

	}

}
