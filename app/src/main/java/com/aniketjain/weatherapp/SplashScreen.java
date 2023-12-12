package com.aniketjain.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.aniketjain.weatherapp.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIME = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Setting Splash
        setupSplashScreen();
    }

    private void setupSplashScreen() {
        new Handler().postDelayed(() -> {
            startHomeActivity();
        }, SPLASH_TIME);

        // Add click listener to skip splash screen if the user taps on it
        findViewById(android.R.id.content).setOnClickListener(v -> startHomeActivity());
    }

    private void startHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    // Override onBackPressed to prevent the user from going back to the splash screen
    @Override
    public void onBackPressed() {
        // Do nothing or handle as per your app's requirements
    }
}
