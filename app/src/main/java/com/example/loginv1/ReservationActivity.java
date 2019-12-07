package com.example.loginv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReservationActivity extends AppCompatActivity {
    Spinner spinner,spinner2,spinner3;
    String park_name,date,time,hour;
    EditText plate;
    TextView park_name_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Intent i = getIntent();
        park_name = i.getStringExtra("markername");
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        plate = findViewById(R.id.editText);
        park_name_text = findViewById(R.id.park_name_text);
        park_name_text.setText(park_name);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1 Saat");
        arrayList.add("2 Saat");
        arrayList.add("3 Saat");
        arrayList.add("4 Saat");
        arrayList.add("5 Saat");
        arrayList.add("6 Saat");
        arrayList.add("7 Saat");
        arrayList.add("8 Saat");
        arrayList.add("9 Saat");
        arrayList.add("10 Saat");
        arrayList.add("11 Saat");
        arrayList.add("12 Saat");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        Calendar calendar = Calendar.getInstance();
        Date today=calendar.getTime();
        ArrayList<String> arrayList2 = new ArrayList<>();
        int ix=0;
        DateFormat dateFormat = new SimpleDateFormat("dd.MMM.yyyy");
        String tarihler = dateFormat.format(today);
        while(ix<30){
            ix++;
            arrayList2.add(tarihler);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            today=calendar.getTime();
            tarihler = dateFormat.format(today);
        }
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("00:00");
        arrayList3.add("01:00");
        arrayList3.add("02:00");
        arrayList3.add("03:00");
        arrayList3.add("04:00");
        arrayList3.add("05:00");
        arrayList3.add("06:00");
        arrayList3.add("07:00");
        arrayList3.add("08:00");
        arrayList3.add("09:00");
        arrayList3.add("10:00");
        arrayList3.add("11:00");
        arrayList3.add("12:00");
        arrayList3.add("13:00");
        arrayList3.add("14:00");
        arrayList3.add("15:00");
        arrayList3.add("16:00");
        arrayList3.add("17:00");
        arrayList3.add("18:00");
        arrayList3.add("19:00");
        arrayList3.add("20:00");
        arrayList3.add("21:00");
        arrayList3.add("22:00");
        arrayList3.add("23:00");
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        date=spinner2.getSelectedItem().toString();
        time=spinner3.getSelectedItem().toString();
        hour=spinner.getSelectedItem().toString();
    }
    public void pay(View view){
        Intent intent = new Intent(ReservationActivity.this,PayActivity.class);
        intent.putExtra("MarkerName",park_name);
        intent.putExtra("Date",date);
        intent.putExtra("Time",time);
        intent.putExtra("Hour",hour);
        intent.putExtra("Plate",plate.getText().toString());
        startActivity(intent);

    }
}
