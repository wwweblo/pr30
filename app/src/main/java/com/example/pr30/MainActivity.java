package com.example.pr30;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1){
            Intent intent = new Intent(this, OneActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.button2){
            Intent intent = new Intent(this, TwoActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.button3){
            Intent intent = new Intent(this, ThreeActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.button4){
            Intent intent = new Intent(this, FourActivity.class);
            startActivity(intent);
        }
    }
}