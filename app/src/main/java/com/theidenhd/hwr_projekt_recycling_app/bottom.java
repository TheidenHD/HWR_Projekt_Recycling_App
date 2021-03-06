package com.theidenhd.hwr_projekt_recycling_app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        inhalt2.setGravity(Gravity.CENTER);
        close.setOnClickListener(view1 -> dismiss());
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(getContext(), getTheme()) {
            @Override
            public void onBackPressed() {
                super.onBackPressed();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        };
    }

    public void setValues(String s) {
        try {
            String tmp = new getHTML().execute("https://world.openfoodfacts.org/api/v0/product/" + s + ".json").get();
            Gson g = new Gson();
            JsonObject jsonObject = g.fromJson(tmp, JsonObject.class);
            this.titelS = jsonObject.getAsJsonObject("product").get("product_name").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.hinweis = new InfoAsyncTask().execute(s).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("StaticFieldLeak")
    public static class getHTML extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                StringBuilder result = new StringBuilder();
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    public static class InfoAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String out = "";


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2/hwr_projekt_recycling_app", "user", "demo");
                PreparedStatement statement = connection.prepareStatement("SELECT Hinweis FROM main WHERE Barcode =" + strings[0]);
                ResultSet results = statement.executeQuery();
                if (results.next()) {
                    out = results.getString(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return out;
        }
    }
}
