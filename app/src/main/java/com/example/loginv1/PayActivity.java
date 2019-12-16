package com.example.loginv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class PayActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Intent i = getIntent();

        String date = i.getStringExtra("date");
        String hour = i.getStringExtra("hour_of_day");
        String minute = i.getStringExtra("minute_of_day");

        String exit_date = i.getStringExtra("exit_date");
        String exit_hour = i.getStringExtra("exit_hour");
        String exit_min = i.getStringExtra("exit_min");


        textView1 = (TextView) findViewById(R.id.date);
        textView2 = (TextView) findViewById(R.id.hour);
        textView3 = (TextView) findViewById(R.id.minute);
        textView4 = (TextView) findViewById(R.id.exit_date);
        textView5 = (TextView) findViewById(R.id.exit_hour);
        textView6 = (TextView) findViewById(R.id.exit_min);

        textView1.setText(date);
        textView2.setText(hour);
        textView3.setText(minute);
        textView4.setText(exit_date);
        textView5.setText(exit_hour);
        textView6.setText(exit_min);
    }
}
