package com.theidenhd.hwr_projekt_recycling_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.WindowManager;
import android.view.Display;
import android.graphics.Point;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Storage {


    private final String[] text;
    private final String[] bild;
    private final Storage[] storage;

    public Storage(String[] te, String[] bi, Storage[] st) {
        this.text = te;
        this.bild = bi;
        this.storage = st;
    }

    public String getTitel() {
        return text[0];
    }

    public View genView(Context context, boolean finall) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        if (finall) {
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            TextView show = new TextView(context);
            show.setText(text[2]);
            show.setGravity(Gravity.CENTER);
            show.setTextAppearance(context, android.R.style.TextAppearance_Material_Display2);
            layout.addView(show);

            TextView show2 = new TextView(context);
            show2.setText(text[3]);
            show2.setGravity(Gravity.CENTER);
            show2.setTextAppearance(context, android.R.style.TextAppearance_Material_Display1);
            layout.addView(show2);

            try {
                ImageView tonne = new ImageView(context);
                tonne.setImageResource(context.getResources().getIdentifier(
                        bild[1],
                        "drawable",
                        context.getPackageName()
                ));
                layout.addView(tonne);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return layout;
        } else {

            Button myButton = new Button(context);
            myButton.setTextSize(27);
          //  myButton.setTextColor(0xFF9400D3);
            myButton.setText(text[1]);
            try {
                @SuppressLint("UseCompatLoadingForDrawables") Drawable bottom = context.getResources().getDrawable(context.getResources().getIdentifier(
                        bild[0],
                        "drawable",
                        context.getPackageName()
                ));

                ScaleDrawable backgroundimage = new ScaleDrawable(bottom, Gravity.FILL_HORIZONTAL | Gravity.CENTER_VERTICAL, -1, (float) 0.4);
                backgroundimage.setLevel(1);
                backgroundimage.setAlpha(100);

                myButton.setBackground(backgroundimage);

            } catch (Exception e) {
                e.printStackTrace();
            }
            myButton.setLayoutParams(new LinearLayout.LayoutParams(width, height / 5));

            return myButton;
        }
    }

    public Storage[] getStorage() {
        return storage;
    }

    static String getJsonFromAssets(Context context) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open("Data.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}
