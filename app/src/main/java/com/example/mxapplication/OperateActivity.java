package com.example.mxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OperateActivity extends AppCompatActivity {
private Button btn_mp3;
private Button btn_mp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operate);
        btn_mp3=findViewById(R.id.btn_mp3);
        btn_mp4=findViewById(R.id.btn_mp4);
        setListeners();
    }
    private void setListeners() {
        Onclick onClick = new Onclick();
        btn_mp4.setOnClickListener(onClick);
        btn_mp3.setOnClickListener(onClick);
    }
    private class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_mp3:
                    intent = new Intent(OperateActivity.this, Mp3Activity.class);
                    break;
                case R.id.btn_mp4:
                    intent = new Intent(OperateActivity.this, Mp4Activity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
