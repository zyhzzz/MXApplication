package com.example.mxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Mp4Activity extends AppCompatActivity implements SurfaceHolder.Callback {
    private Button btn;
    private Button button_pause;
    private SurfaceView surfaceView;
    private MediaPlayer mp;
    private SurfaceHolder mSurfaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp4);
        btn=findViewById(R.id.button_start);
        button_pause= findViewById(R.id.button_pause);
        surfaceView =findViewById(R.id.surfaceView);
        mp=new MediaPlayer();
        mp= MediaPlayer.create(this,R.raw.demo);
        mSurfaceHolder = surfaceView.getHolder();
        mSurfaceHolder.addCallback((SurfaceHolder.Callback) this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                btn.setEnabled(false);
                button_pause.setEnabled(true);
            }
        });
        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                btn.setEnabled(true);
                button_pause.setEnabled(false);
            }
        });
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mp.setDisplay(holder);//给mMediaPlayer添加预览的SurfaceHolder
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mp=null;
    }


}

