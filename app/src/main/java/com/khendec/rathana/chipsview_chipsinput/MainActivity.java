package com.khendec.rathana.chipsview_chipsinput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onChipsView(View view) {
        Intent intent=new Intent(MainActivity.this,ChipsViewActivity.class);
        startActivity(intent);
    }

    public void onChipsInput(View view) {
        Intent intent=new Intent(MainActivity.this,ChipsInputActivity.class);
        startActivity(intent);
    }
}
