package com.theidenhd.hwr_projekt_recycling_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class bottom extends BottomSheetDialogFragment {

    private String titelS = "";
    private String hinweis = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom, container, false);
        TextView title = view.findViewById(R.id.text_titel);
        TextView inhalt = view.findViewById(R.id.text_inhalt);
        TextView inhalt2 = view.findViewById(R.id.text_inhalt2);
        ImageView close = view.findViewById(R.id.close);
        title.setText(titelS);
        inhalt.setText("Trennhinweis:");
        inhalt2.setText(hinweis);
        close.setOnClickListener(view1 -> dismiss());
        return view;
    }

    public void setValues(String s) {
        //String tmp = getHTML("https://api.barcodelookup.com/v3/products?barcode=4004980517004&formatted=y&key=hbsgiixhog2a1rukwangvpxnwegaj5");
        String tmp ="{\"products\": [{\"title\": \"Ltje Extra Roast Gesalzen\"}]}";
        Gson g = new Gson();
        JsonObject jsonObject = g.fromJson( tmp, JsonObject.class);
        String a = ((JsonObject)((JsonArray)jsonObject.get("products")).get(0)).get("title").getAsString();
        this.titelS = a;
    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
