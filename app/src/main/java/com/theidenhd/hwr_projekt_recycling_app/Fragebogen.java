package com.theidenhd.hwr_projekt_recycling_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Fragebogen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragebogen);
        createLayoutDynamically(2);
    }

    String[][] demo = {{"Becher", "Glas"}, {"Joghurt", "Butter/Magarine", "Milch"}, {"Fertiggerichte", "Snacks", "Molkereiprodukte", "Konserven"}};
    String[] demo2 = {"Welches Material?","Welcher Produkttyp?","Aus welcher Abteilung stammt es?"};

    private void createLayoutDynamically(int n) {
        LinearLayout layout = findViewById(R.id.Frage);
        layout.removeAllViews();
        if (n >= 0) {
            setTitle(demo2[n]);
            for (String s : demo[n]) {
                Button myButton = new Button(this);
                myButton.setText(s);

                layout.addView(myButton);
                if (s.equals("Molkereiprodukte") || s.equals("Joghurt") || s.equals("Becher"))
                    myButton.setOnClickListener(view ->
                            createLayoutDynamically(n - 1));
                else{
                    myButton.setOnClickListener(view ->
                    Toast.makeText(Fragebogen.this,
                    "Error: Daten nicht vorhanden!",
                    Toast.LENGTH_SHORT)
                    .show());
                }
            }
        } else {
            setTitle("Trennhinweis:");
            TextView show = new TextView(this);
            show.setText("Gelbe Tonne, Becher vom Deckel trennen.");
            show.setGravity(Gravity.CENTER);
            layout.addView(show);
        }
    }

}