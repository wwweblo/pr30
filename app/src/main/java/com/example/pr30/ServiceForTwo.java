package com.example.pr30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceForTwo extends Service {

    final String LOG_TAG = "myLogs";
    ExecutorService es;
    Object someRes;

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "Service onCreate");
        es = Executors.newFixedThreadPool(3);
        someRes = new Object();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Service onDestroy");
        someRes = null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "Service onStartCommand");
        int time = intent.getIntExtra("meow", 1);
        MyRun mr = new MyRun(time, startId);
        es.execute(mr);
        return super.onStartCommand(intent, flags, startId);
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    class MyRun implements Runnable {

        int time;
        int startId;

        public MyRun(int time, int startId) {
            this.time = time;
            this.startId = startId;
            Log.d(LOG_TAG, "Run#" + startId + " create");
        }

        public void run() {
            Log.d(LOG_TAG, "Run#" + startId + " start, time = " + time);
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Log.d(LOG_TAG, "Run#" + startId + " someRes = " + someRes.getClass() );
            } catch (NullPointerException e) {
                Log.d(LOG_TAG, "Run#" + startId + " error, null pointer");
            }
            stop();
        }

        void stop() {
            Log.d(LOG_TAG, "Run#" + startId + " end, stopSelfResult("
                    + startId + ") = " + stopSelfResult(startId));
        }
    }
}
