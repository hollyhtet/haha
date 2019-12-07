package com.htet.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TimeActivity extends AppCompatActivity {
    public static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        textView = findViewById(R.id.txtDatetime);
    }



    public void btnShow_Click(View view) {
        FragmentManager fm = getSupportFragmentManager();
        PopTime popTime = new PopTime();
        popTime.show(fm, "Show Fragment");
    }
}
