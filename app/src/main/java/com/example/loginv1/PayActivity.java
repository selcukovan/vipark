package com.example.loginv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class PayActivity extends AppCompatActivity {
    String plate,date,time,hour,name;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Intent i = getIntent();
        name = i.getStringExtra("MarkerName");
        plate = i.getStringExtra("Plate");
        time = i.getStringExtra("Time");
        hour = i.getStringExtra("Hour");
        date = i.getStringExtra("Date");



    }
}
