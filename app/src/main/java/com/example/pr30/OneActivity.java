package com.example.pr30;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
        создаем, запускаем и останавливаем простой сервис
*/
public class OneActivity extends Activity {
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }

    public void onClickStart(View v) {
        startService(new Intent(this, ServiceForOne.class));
    }

    public void onClickStop(View v) {
        stopService(new Intent(this, ServiceForOne.class));
    }
    public void onClickBack(View v) {
        finish();
    }
}
