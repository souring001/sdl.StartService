package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION_ANSWER = "ActionANS";
    public final static String EXTRA_ANSWER = "ExtraANS";

    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));

        for(int i = 0; i < 10; i ++) {
            Intent intent2 = new Intent();
            intent2.setAction(ACTION_ANSWER);
            intent2.putExtra(EXTRA_ANSWER, "This message is broadcast to you: " + i);
            sendBroadcast(intent2);
            Log.d(TAG, "Broadcast in " + Thread.currentThread());

            try {
                Thread.sleep(1000); // 1 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}
