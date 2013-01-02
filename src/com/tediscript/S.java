/*

ShortCode
Helper library for Android Apps
Mission: reduce the line of code
inspired by https://github.com/pocorall/scaloid

DRAFT:
ShortCode.openYoutube(String code)
ShortCode.spinnerDialog(String title, String message)
ShortCode.vibrate(int miliseconds)
ShortCode.alert(String title, String message)
ShortCode.get(String url, Shortuct.callback)
ShortCode.post(String url, String data, ShortCode.callback)

DONE:
ShortCode.toast(String message)
ShortCode.longToast(String message)
ShortCode.verbose(String tag, String message)
ShortCode.debug(String tag, String message)
ShortCode.info(String tag, String message)
ShortCode.warn(String tag, String message)
ShortCode.error(String tag, String message)
ShortCode.share(String text)
ShortCode.share(String tag, String text)
ShortCode.play(int resource)
ShortCode.pause()
ShortCode.resume()
ShortCode.stop()
ShortCode.putString(String key, String value)
ShortCode.getString(String key, String defaultValue)
ShortCode.putInt(String key, int value)
ShortCode.getInt(String key, int defaultValue)
ShortCode.putBoolean(String key, bool value)
ShortCode.getBoolean(String key, bool defaultValue)
ShortCode.openUri(String url)
 */

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
	public static MediaPlayer mp;

	public static void init(Context ctx) {
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
		mp = MediaPlayer.create(S.ctx, resource);
		mp.start();
	}

	public static void pause() {
		if (mp != null) {
			if (mp.isPlaying()) {
				mp.pause();
			}
		}
	}

	public static void resume() {
		if (mp != null) {
			if (mp.isPlaying()) {
				mp.pause();
			}
		}
	}

	public static void stop() {
		if (mp != null) {
			if (mp.isPlaying()) {
				mp.stop();
			}
		}
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
