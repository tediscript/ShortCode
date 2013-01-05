ShortCode
=========

Android library to reduce a line of code<br/>
inspired by https://github.com/pocorall/scaloid
and http://redbeanphp.com/

### DRAFT:
	S.spinnerDialog(String title, String msg)
	S.alert(String title, String msg)
	S.get(String url, Shortuct.callback)
	S.post(String url, String data, S.callback)
	S.dial(String phoneNumber()
	S.getIMEI()
	S.getPhoneNetworkType()
	S.shakeView()

### DONE:
	S.toast(String msg)
	S.longToast(String msg)
	S.verbose(String tag, String msg)
	S.debug(String tag, String msg)
	S.info(String tag, String msg)
	S.warn(String tag, String msg)
	S.error(String tag, String msg)
	S.share(String text)
	S.share(String tag, String text)
	S.play(int resource)
	S.putString(String key, String value)
	S.getString(String key, String default)
	S.putInt(String key, int value)
	S.getInt(String key, int defaultValue)
	S.putBoolean(String key, boolean value)
	S.getBoolean(String key, boolean default)
	S.openUrl(String url)
	S.openYoutube(String code)
	S.startActivity(Class <?> cls)
	S.startActivity(Class <?> cls, String data)
	S.getDeviceId()
	S.vibrate(long miliseconds)
	S.vibrate(long [] intervals)
	S.notification(int notifId, int resIconId, String title, String text, Class <?> cls)


### REMOVED
	S.pause()
	S.resume()
	S.stop()

