package com.alicandogru.cardmatchinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SecimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secim);
    }

    public void tekClick(View view){
        Intent intent = new Intent(SecimActivity.this,TekLevel1Activity.class);
        startActivity(intent);
        finish();

    }
    public void cokClick(View view) {
        Intent intent = new Intent(SecimActivity.this, CokLevel1Activity.class);
        startActivity(intent);
        finish();
    }
}