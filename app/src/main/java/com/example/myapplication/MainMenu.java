package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private Button normalMode;
    private Button misereMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar().hide();

        normalMode = (Button) findViewById(R.id.normalModeBtn);
        misereMode = (Button) findViewById(R.id.misereModeBtn);

        normalMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchNormalActivity();
            }
        });
        misereMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchMisereActivity();
            }
        });
    }
    private void switchNormalActivity(){
        Intent switchNormal = new Intent(this, MainActivity.class);
        startActivity(switchNormal);
    }
    private void switchMisereActivity(){
        Intent switchMisere = new Intent(this, MisereMode.class);
        startActivity(switchMisere);
    }
}