package com.theidenhd.hwr_projekt_recycling_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class bottom extends BottomSheetDialogFragment {

    private String titelS = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom, container, false);
        TextView title = view.findViewById(R.id.text_titel);
        TextView inhalt = view.findViewById(R.id.text_inhalt);
        TextView inhalt2 = view.findViewById(R.id.text_inhalt2);
        ImageView close = view.findViewById(R.id.close);
        title.setText(titelS);
        close.setOnClickListener(view1 -> dismiss());
        return view;
    }

    public void setValues(String s) {
        this.titelS = s;
    }
}
