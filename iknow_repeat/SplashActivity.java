package com.example.iknow_repeat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    ProgressBar progressBar;

    int progresstatus = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.Splash_progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (progresstatus <100){

                    progresstatus += 1;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {progressBar.setProgress(progresstatus);

                        }
                    });
                    try {
                        Thread.sleep(50);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                if(progresstatus >= 100){

                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }).start();

    }
}