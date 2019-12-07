package com.htet.timepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PopTime extends DialogFragment implements View.OnClickListener {
    View view;
    DatePicker tp;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.timepickerdialog,container,false);
        tp =(DatePicker)view.findViewById(R.id.dtpicker);
        Button btnDone = view.findViewById(R.id.btndone);
        btnDone.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        dismiss();
        String selectedtime= tp.getMonth()+":"+tp.getYear();
        TimeActivity.textView.setText(selectedtime);
    }
}
