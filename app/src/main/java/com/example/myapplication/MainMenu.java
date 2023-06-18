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
    private Button settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar().hide();

        normalMode = (Button) findViewById(R.id.normalModeBtn);
        misereMode = (Button) findViewById(R.id.misereModeBtn);
        settings = (Button) findViewById(R.id.settingsBtn);

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
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchSettingsActivity();
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
    private void switchSettingsActivity(){
        Intent swtichSettings = new Intent(this, SettingsActivity.class);
        startActivity(swtichSettings);
    }
}