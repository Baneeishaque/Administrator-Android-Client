package administrator.ui.initialization;

import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Terms extends Activity {

	private CheckBox chkbaccept;
	private Button bsubmit;
	private Button bexit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.terms);

		chkbaccept = (CheckBox) findViewById(R.id.chkbaccept);
		bsubmit = (Button) findViewById(R.id.bsubmit);
		bexit = (Button) findViewById(R.id.bexit);

		WebView wv = (WebView) findViewById(R.id.wbvwlicense);
		wv.loadUrl("file:///android_asset/license.html");
		bsubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (chkbaccept.isChecked()) {
					Intent target = new Intent(arg0.getContext(), About.class);
					startActivity(target);
				} else {
					Toast.makeText(getApplicationContext(), "Please Confirm Your Acceptance", Toast.LENGTH_LONG).show();
				}
			}
		});

		bexit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);

			}
		});

	}

	@Override
	public void onBackPressed() {

	}

}
