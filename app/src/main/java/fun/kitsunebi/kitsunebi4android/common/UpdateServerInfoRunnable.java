package fun.kitsunebi.kitsunebi4android.common;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

import fun.kitsunebi.kitsunebi4android.storage.Preferences;
import fun.kitsunebi.kitsunebi4android.ui.SplashActivity;

public class UpdateServerInfoRunnable extends WorkRunnable {
    private WeakReference<SplashActivity> mRef;
    private UpdateCallback mCallback;

    public UpdateServerInfoRunnable(SplashActivity splashActivity, UpdateCallback pCallback) {
        mRef = new WeakReference<>(splashActivity);
        mCallback = pCallback;
    }

    @Override
    void doRun() {
        if (mRef.get() != null) {
            final String str = Preferences.Companion.getString(mRef.get(), Constants.Companion.getPREFERENCE_CONFIG_KEY(), Constants.Companion.getDEFAULT_CONFIG());
            String data = get("http://192.168.10.242:8080/index.html");
            try {
                JSONObject orignaljsonObject = new JSONObject(str);
                JSONArray outboundsArray = orignaljsonObject.optJSONArray("outbounds");
                JSONObject vmessObject = null;
                for (int i = 0; i < outboundsArray.length(); i++) {
                    JSONObject jsonObject = outboundsArray.optJSONObject(i);
                    String protocol = jsonObject.optString("protocol");
                    if ("vmess".equalsIgnoreCase(protocol)) {
                        vmessObject = jsonObject;
                        break;
                    }
                }
                JSONObject newSettingObj = new JSONObject(data);
                if (newSettingObj != null) {
                    if (vmessObject != null) {
                        vmessObject.put("settings", newSettingObj);
                    }
                }
                Preferences.Companion.putString(mRef.get(), Constants.Companion.getPREFERENCE_CONFIG_KEY(), orignaljsonObject.toString());

                String s = Preferences.Companion.getString(mRef.get(), Constants.Companion.getPREFERENCE_CONFIG_KEY(), Constants.Companion.getDEFAULT_CONFIG());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if(mCallback != null){
            mCallback.onUpdated();
        }
    }

    public interface UpdateCallback{
        void onUpdated();
    }
}
