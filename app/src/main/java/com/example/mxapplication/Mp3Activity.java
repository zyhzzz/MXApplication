package com.example.mxapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import java.util.Timer;
import java.util.TimerTask;
public class Mp3Activity extends AppCompatActivity {
private Button bt_start;
private Button bt_pause;
private Button bt_stop;
private SeekBar sb;
private MediaPlayer mp3Player;
    private String tag="MyMusicService";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);
        bt_start = findViewById(R.id.bt_start);
        bt_stop= findViewById(R.id.bt_stop);
        bt_pause= findViewById(R.id.bt_pause);
        sb = findViewById(R.id.seekBar);
        mp3Player = new MediaPlayer();
        mp3Player = MediaPlayer.create(Mp3Activity.this, R.raw.test);
// 播放器跟音乐关联起来
        mp3Player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                System.out.println("完成。");
                bt_start.setEnabled(true);//“播放”按钮可用
            }
        });
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                bt_pause.setEnabled(true);
                bt_start.setEnabled(false);//“播放”按钮不可用
                bt_stop.setEnabled(true);
                if (mp3Player == null) {
                    bt_start.setEnabled(true);
                }
            }
        });
        bt_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_start.setEnabled(true);
                mp3Player.pause();
                bt_pause.setEnabled(false);//“播放”按钮可用
            }
        });
        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3Player.reset();
                mp3Player = MediaPlayer.create(Mp3Activity.this, R.raw.test);
                bt_start.setEnabled(true);
                bt_pause.setEnabled(false);
                bt_stop.setEnabled(false);
            }
        });
 sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int process = seekBar.getProgress();
                if (mp3Player != null) {
                    mp3Player.seekTo(process);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void play() {
        try {
            System.out.println("正在播放.....");
            mp3Player.start();
            bt_start.setEnabled(true);//“播放”按钮可用
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



