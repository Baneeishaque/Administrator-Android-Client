package administrator.ui.general;

import android.androidVNC.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Habout extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.habout);

		WebView wv = (WebView) findViewById(R.id.wbvwabout);
		wv.loadUrl("file:///android_asset/about.html");

	}
}
