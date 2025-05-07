package SplashScreen;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidpractice.R;
import com.example.androidpractice.SuplierActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // i have use two method for intro screen using Helper class and using Thread class
        progressBar();
        helpermehtod();
        // threadMethod();
    }
    public void progressBar() {
        progressBar = findViewById(R.id.progressBarSplashScreen);

        // Using ObjectAnimator for smooth progress update
        ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
        animator.setDuration(5000);
        animator.start();
    }

    // Use this when: You need custom step-by-step updates.

//    @SuppressLint("ObjectAnimatorBinding")
//    public void progressBar() {
//        progressBar = findViewById(R.id.progressBarSplashScreen);
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            int count = 0;
//            @Override
//            public void run() {
//                count++;
//                progressBar.setProgress(count);
//                if (count == 100) {
//                    timer.cancel();
//                }
//            }
//        };
//        timer.schedule(timerTask, 0, 100);  // Updates every 100ms
//    }

    // In this method used HandlerClass and Handled class provide feature from SDK
    void helpermehtod() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, SuplierActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

    // In this method used ThreadClass and Thread is concept of java
    void threadMethod() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, SuplierActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}