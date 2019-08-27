package fun.kitsunebi.kitsunebi4android.common;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class WorkRunnable implements Runnable {
    OkHttpClient client = new OkHttpClient();
    @Override
    public void run() {
        try{
            doRun();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    abstract void doRun();

    String get(String url)  {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            return null;
        }

    }
}
