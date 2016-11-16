package administrator.ui.initialization;

import android.androidVNC.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		WebView wv = (WebView) findViewById(R.id.wbvwabout);
		wv.loadUrl("file:///android_asset/about.html");

	}

	public void next(View view) {
		Intent target = new Intent(this, Security.class);
		startActivity(target);
	}

}
