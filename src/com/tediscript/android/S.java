package com.tediscript.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.util.Log;
import android.widget.Toast;

public class S {

	private static Context ctx;
	private static String PREFS_NAME = "com.tediscript.android.s.settings";
	private static ProgressDialog loading;

	public static void setup(Context ctx) {
		S.ctx = ctx;
	}

	public static void loading(int resId) {
		S.loading(S.ctx.getString(resId));
	}

	public static void loading(String msg) {
		loading = new ProgressDialog(S.ctx);
		loading.setMessage(msg);
		loading.show();
	}

	public static void dismiss() {
		try {
			loading.dismiss();
		} catch (Exception e) {

		}
	}

	public static void log(String msg) {
		S.verbose("LOG", msg);
	}

	public static void verbose(String tag, String msg) {
		Log.v(tag, msg);
	}

	public static void debug(String tag, String msg) {
		Log.d(tag, msg);
	}

	public static void info(String tag, String msg) {
		Log.i(tag, msg);
	}

	public static void warn(String tag, String msg) {
		Log.w(tag, msg);
	}

	public static void error(String tag, String msg) {
		Log.e(tag, msg);
	}

	public static void toast(int resId) {
		S.toast(S.ctx.getString(resId));
	}

	public static void toast(String text) {
		Toast.makeText(S.ctx, text, Toast.LENGTH_SHORT).show();
	}

	public static void longToast(int resId) {
		S.longToast(S.ctx.getString(resId));
	}

	public static void longToast(String text) {
		Toast.makeText(S.ctx, text, Toast.LENGTH_LONG).show();
	}

	public static void share(String text) {
		S.share("", text);
	}

	public static void share(String title, String text) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, text);
		sendIntent.setType("text/plain");
		ctx.startActivity(Intent.createChooser(sendIntent, title));
	}

	public static void play(int resId) {
		MediaPlayer.create(S.ctx, resId).start();
	}

	public static void putString(String key, String value) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static String getString(String key, String defValue) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getString(key, defValue);
	}

	public static void putInt(String key, int value) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static int getInt(String key, int defValue) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getInt(key, defValue);
	}

	public static void putBoolean(String key, boolean value) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static boolean getBoolean(String key, boolean defValue) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getBoolean(key, defValue);
	}

	public static void openUrl(String url) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		S.ctx.startActivity(i);
	}

	public static void openYoutube(String code) {
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"
				+ code));
		S.ctx.startActivity(i);
	}

	public static void startActivity(Class<?> cls) {
		S.startActivity(cls, "");
	}

	public static void startActivity(Class<?> cls, String data) {
		Intent intent = new Intent(S.ctx, cls);
		intent.putExtra("data", data);
		S.ctx.startActivity(intent);
	}

	public static String getDeviceId() {
		return Secure.getString(S.ctx.getContentResolver(), Secure.ANDROID_ID);
	}

	public static void vibrate(long miliseconds) {
		S.vibrate(new long[] { miliseconds, miliseconds });
	}

	public static void vibrate(long[] intervals) {
		@SuppressWarnings("static-access")
		NotificationManager notificationManager = (NotificationManager) S.ctx
				.getSystemService(S.ctx.NOTIFICATION_SERVICE);
		Notification notification = new Notification();
		notification.vibrate = intervals;
		notificationManager.notify(0, notification);
	}

}
