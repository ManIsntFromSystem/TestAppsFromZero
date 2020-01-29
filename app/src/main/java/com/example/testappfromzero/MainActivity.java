package com.example.testappfromzero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.imageView)
    ImageView imageView1;

    @BindView(R.id.imageView2)
    ImageView imageView2;

    boolean isEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        imageView1.animate().alpha(1).rotation(1800).scaleX(0.5f).scaleY(0.5f).setDuration(3000);
    }

    public void changeImage(View view) {
        if(isEnabled) {
            imageView1.animate().alpha(0).rotation(1800).scaleX(0).scaleY(0).setDuration(3000);
            imageView2.animate().alpha(1).rotation(-1800).scaleX(1).scaleY(1).setDuration(3000);
            isEnabled = false;
        } else {
            imageView2.animate().alpha(0).rotation(1800).scaleX(0).scaleY(0).setDuration(3000);
            imageView1.animate().alpha(1).rotation(-1800).scaleX(1).scaleY(1).setDuration(3000);
            isEnabled = true;
        }
    }
    public void replaceImages(){

    }
}
