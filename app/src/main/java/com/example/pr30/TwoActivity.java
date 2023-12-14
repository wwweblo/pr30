package com.example.pr30;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
        передаем данные в сервис
*/
public class TwoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


    }

    public void onClickStart(View v) {
        startService(new Intent(this, ServiceForTwo.class).putExtra("meow", 7));
        startService(new Intent(this, ServiceForTwo.class).putExtra("meow", 2));
        startService(new Intent(this, ServiceForTwo.class).putExtra("meow", 4));
    }
    public void onClickBack(View v) {
        finish();
    }
}
/*
        вернул true, и тем самым сообщил нам, что именно он остановил сервис.
        вернул false – вызов не привел к остановке сервиса.
*/
