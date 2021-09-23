package com.theidenhd.hwr_projekt_recycling_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Fragebogen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragebogen);
        createLayoutDynamically(5);

    }

    private void createLayoutDynamically(int n){
        LinearLayout layout = findViewById(R.id.Frage);
        layout.removeAllViews();

        for (int i = 0; i < n; i++){
            Button myButton = new Button(this);
            myButton.setText("Button :"+i);
            myButton.setId(i);
            final int id_ = myButton.getId();

            layout.addView(myButton);

            myButton.setOnClickListener(view ->
                    Toast.makeText(Fragebogen.this,
                    "Button clickt index = " + id_,
                    Toast.LENGTH_SHORT)
                    .show());
        }
    }

}