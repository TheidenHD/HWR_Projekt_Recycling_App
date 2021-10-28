package com.theidenhd.hwr_projekt_recycling_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class Fragebogen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gson gson = new Gson();
        stor = gson.fromJson(Storage.getJsonFromAssets(this), Storage.class);

        setContentView(R.layout.activity_fragebogen);
        createLayoutDynamically(stor);
    }

    Storage stor;

    @SuppressLint("SetTextI18n")
    private void createLayoutDynamically(Storage s) {
        LinearLayout layout = findViewById(R.id.Frage);
        layout.removeAllViews();
        setTitle(s.getTitel());
        if (s.getStorage().length > 0)
            for (Storage st : s.getStorage()) {
                View temp = st.genView(this, false);
                layout.addView(temp);
                temp.setOnClickListener(view ->
                        createLayoutDynamically(st));

            }
        else
            layout.addView(s.genView(this, true));

    }
}