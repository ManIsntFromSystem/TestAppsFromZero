package com.example.testappfromzero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        imageView1.animate().alpha(0).setDuration(3000);

    }

    public void chengeImage1(View view) {
        imageView1.animate().alpha(0).setDuration(3000);
        imageView2.animate().alpha(1).setDuration(3000);
    }

    public void chengeImage2(View view) {
        imageView2.animate().alpha(0).setDuration(3000);
        imageView1.animate().alpha(1).setDuration(3000);
    }
}
