package com.khendec.rathana.chipsview_chipsinput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_chips_view)
    public void onChipsView(View view) {
        Intent intent=new Intent(MainActivity.this,ChipsViewActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_chips_input)
    public void onChipsInput(View view) {
        Intent intent=new Intent(MainActivity.this,ChipsInputActivity.class);
        startActivity(intent);
    }
}
