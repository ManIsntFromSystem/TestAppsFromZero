package com.example.testappfromzero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoApp extends AppCompatActivity {

    @BindView(R.id.videoView)
    VideoView testVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_app);
        ButterKnife.bind(this);

        testVideo.setVideoPath("android.resource://" + getPackageName() +
                "/" + R.raw.ih);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(testVideo);
        testVideo.setMediaController(mediaController);
        testVideo.start();
    }

    /*VideoView videoview = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
        videoview.setVideoURI(uri);
        videoview.start();*/
}
