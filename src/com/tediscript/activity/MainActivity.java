package com.tediscript.activity;

import com.tediscript.android.S;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		S.setup(MainActivity.this);
		// S.debug("tagggggg", "haee....");
		// S.longToast("lamaaaa....");
		// S.share("bagiken");
		// S.play(R.raw.proklamasi);
		// S.openUrl("http://google.com");
		// S.openYoutube("72ia9XzySro");
		// S.loading(S.getDeviceId());
		// S.dismiss();
		// S.vibrate(1000);
		// S.vibrate(new long[]{1000, 1000});
		// S.loading(S.md5("hahaha"));
		// S.dial("08996808436");
		S.notification(R.drawable.ic_launcher, "Judulnya", "Isinya",
				MainActivity.class);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
