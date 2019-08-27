package fun.kitsunebi.kitsunebi4android.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;

import fun.kitsunebi.kitsunebi4android.R;
import fun.kitsunebi.kitsunebi4android.common.Constants;
import fun.kitsunebi.kitsunebi4android.common.UpdateServerInfoRunnable;
import fun.kitsunebi.kitsunebi4android.storage.Preferences;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SplashActivity extends AppCompatActivity implements UpdateServerInfoRunnable.UpdateCallback {

    Handler mMainHandler, requestHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mMainHandler = new Handler(getMainLooper());
        HandlerThread handlerThread = new HandlerThread("request-thread");
        handlerThread.start();
        requestHandler = new Handler(handlerThread.getLooper());
        requestHandler.post(new UpdateServerInfoRunnable(this, this));
    }


    @Override
    public void onUpdated() {
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        });
    }
}
