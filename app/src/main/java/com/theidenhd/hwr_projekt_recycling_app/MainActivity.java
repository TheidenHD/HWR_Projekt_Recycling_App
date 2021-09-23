package com.theidenhd.hwr_projekt_recycling_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button_scanner = findViewById(R.id.button);
        button_scanner.setOnClickListener(v -> {
            // Scanner einbinden
        });


        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            // FRAGEBOGEN ERSTELLEN
            startActivity(new Intent(MainActivity.this, Fragebogen.class));
        });
    }
}