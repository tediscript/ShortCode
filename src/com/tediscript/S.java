package com.tediscript;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class S {

	public static String PREFS_NAME = "com.tediscript.android.s.settings";
	public static Context ctx;

	public static void setup(Context ctx) {
		S.ctx = ctx;
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

	public static void toast(String text) {
		Toast.makeText(S.ctx, text, Toast.LENGTH_SHORT).show();
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

	public static void play(int resource) {
		MediaPlayer.create(S.ctx, resource).start();
	}

	public static void putString(String key, String value) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static String getString(String key, String defaultValue) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getString(key, defaultValue);
	}

	public static void putInt(String key, int value) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static int getInt(String key, int defaultValue) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getInt(key, defaultValue);
	}

	public static void putBoolean(String key, boolean value) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static boolean getBoolean(String key, boolean defaultValue) {
		SharedPreferences settings = S.ctx.getSharedPreferences(PREFS_NAME, 0);
		return settings.getBoolean(key, defaultValue);
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

}
