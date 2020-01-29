package com.example.testappfromzero;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicActivity extends AppCompatActivity {

    @BindView(R.id.imagePlaySong)
    ImageView btnPlay;
    @BindView(R.id.imageNextSong)
    ImageView btnNextSong;
    @BindView(R.id.imagePreviousSong)
    ImageView btnPreviousSong;
    @BindView(R.id.seekBarVolume)
    SeekBar seekBar;
    @BindView(R.id.seekBarPlay)
    SeekBar seekBarPlay;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Drawable drawablePlayPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        seekBar.setMax(maxVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnPlay.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()){
                pauseMusic();
            } else {
                playMusic();
            }
        });

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kaleo_way_down);
        updateSeekBarPlay();
    }

    public void updateSeekBarPlay(){
        seekBarPlay.setMax(mediaPlayer.getDuration());
        seekBarPlay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBarPlay.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);
    }

    private void playMusic() {
        mediaPlayer.start();
        drawablePlayPause = getResources().getDrawable(R.drawable.icon_pause);
        btnPlay.setImageDrawable(drawablePlayPause);
    }

    public void pauseMusic(){
        mediaPlayer.pause();
        drawablePlayPause = getResources().getDrawable(R.drawable.icon_play);
        btnPlay.setImageDrawable(drawablePlayPause);
    }

    public void nextSong(View view) {
    }

    public void previousSong(View view) {
    }
}
