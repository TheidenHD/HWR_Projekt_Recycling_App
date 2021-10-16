package com.theidenhd.hwr_projekt_recycling_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();


        final Button button_scanner = findViewById(R.id.button);
        button_scanner.setOnClickListener(v -> {
            // Scanner einbinden
            startActivity(new Intent(MainActivity.this, Scanner.class));
        });


        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            // FRAGEBOGEN ERSTELLEN
            startActivity(new Intent(MainActivity.this, Fragebogen.class));
        });
    }
}