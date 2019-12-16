package com.example.loginv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;
import com.aigestudio.wheelpicker.widgets.WheelAreaPicker;
import com.aigestudio.wheelpicker.widgets.WheelDatePicker;
import com.aigestudio.wheelpicker.widgets.WheelDayPicker;
import com.aigestudio.wheelpicker.widgets.WheelMonthPicker;
import com.aigestudio.wheelpicker.widgets.WheelYearPicker;
import com.example.loginv1.PayActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class rezervation_activity_with_wheel_time_picker extends AppCompatActivity {

    WheelPicker wheelPicker;
    WheelPicker wheelPicker2;
    WheelPicker wheelPicker3;

    WheelPicker wheel_picker_exit_date;
    WheelPicker wheel_picker_exit_hour;
    WheelPicker wheel_picker_exit_min;



    String tarih;
    String hour;
    String minute;
    String date;
    String hour_of_selected_day;
    String minute_of_selected_day;



    String exit_date;
    String exit_hour;
    String exit_min;
    String exit_date_data;
    String exit_hour_data;
    String exit_min_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervation_with_wheel_time_picker);

        //*********************************** NEW ENTRANCE ******************

        wheelPicker = findViewById(R.id.wheel_picker);
        wheelPicker2 = findViewById(R.id.wheel_picker2);
        wheelPicker3 = findViewById(R.id.wheel_picker3);


        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();

        Date today = calendar.getTime();
        Date today2 = calendar2.getTime();
        Date today3 = calendar3.getTime();

        List<String> wheel_dates = new ArrayList<>();
        List<String> wheel_hours = new ArrayList<>();
        List<String> wheel_minutes = new ArrayList<>();
        wheel_dates.add("Pick Date");
        wheel_hours.add("H");
        wheel_minutes.add("M");


        //*********************************************************************


        //******************************** NEW EXİT ***************************

        wheel_picker_exit_date = findViewById(R.id.wheel_picker_exit_date);
        wheel_picker_exit_hour = findViewById(R.id.wheel_picker_exit_hour);
        wheel_picker_exit_min = findViewById(R.id.wheel_picker_exit_min);


        Calendar calendar4 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        Calendar calendar6 = Calendar.getInstance();

        Date exit_day = calendar4.getTime();
        Date exit_day2 = calendar5.getTime();
        Date exit_day3 = calendar6.getTime();

        List<String> wheel_dates_exit = new ArrayList<>();
        List<String> wheel_hours_exit = new ArrayList<>();
        List<String> wheel_minutes_exit = new ArrayList<>();
        wheel_dates_exit.add("Pick Date");
        wheel_hours_exit.add("H");
        wheel_minutes_exit.add("M");


        //**********************************************************************

        //************************************** NEW ENTRANCE*******************
        int ix = 0;
        int iy = 0;

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        tarih = dateFormat.format(today);

        DateFormat dateFormat1 = new SimpleDateFormat("hh :");
        hour = dateFormat1.format(today2);

        DateFormat dateFormat2 = new SimpleDateFormat("mm");
        minute = dateFormat2.format(today3);

        while(ix<30){
            ix++;
            wheel_dates.add(tarih);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            today=calendar.getTime();
            tarih = dateFormat.format(today);
        }
        while(iy<23){
            iy++;
            wheel_hours.add(hour);
            calendar2.add(Calendar.HOUR, 1);
            today2 = calendar2.getTime();
            hour = dateFormat1.format(today2);
        }
        wheel_minutes.add("00");
        wheel_minutes.add("15");
        wheel_minutes.add("30");
        wheel_minutes.add("45");

        wheelPicker.setData(wheel_dates);
        wheelPicker2.setData(wheel_hours);
        wheelPicker3.setData(wheel_minutes);

        wheelPicker3.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                minute_of_selected_day = data.toString();
            }
        });
        wheelPicker2.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                hour_of_selected_day = data.toString();
            }
        });
        wheelPicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                date = data.toString();
            }
        });

        wheel_picker_exit_date.setData(wheel_dates);
        wheel_picker_exit_hour.setData(wheel_hours);
        wheel_picker_exit_min.setData(wheel_minutes);

        wheel_picker_exit_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                exit_min_data = data.toString();
            }
        });
        wheel_picker_exit_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                exit_hour_data = data.toString();
            }
        });
        wheel_picker_exit_date.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                exit_date_data = data.toString();
            }
        });



        //****************************************************************************

        //******************************************NEW EXİT**************************
/*   Bu bölümde bir hata var tekrardan incelemelisin burayı
        int iz = 0;
        int ij = 0;

        DateFormat dateFormat_for_exit_date = new SimpleDateFormat("dd MMMM yyyy");
        exit_date = dateFormat_for_exit_date.format(exit_day);

        DateFormat dateFormat_for_exit_hour = new SimpleDateFormat("hh :");
        exit_hour = dateFormat_for_exit_hour.format(exit_day2);

        DateFormat dateFormat_for_exit_min = new SimpleDateFormat("mm");
        exit_min = dateFormat_for_exit_min.format(exit_day3);

        while(iz<30){
            ix++;
            wheel_dates_exit.add(exit_date);
            calendar4.add(Calendar.DAY_OF_YEAR, 1);
            exit_day=calendar4.getTime();
            exit_date = dateFormat.format(exit_day);
        }
        while(ij<23){
            iy++;
            wheel_hours_exit.add(exit_hour);
            calendar5.add(Calendar.HOUR, 1);
            exit_day2 = calendar5.getTime();
            exit_hour = dateFormat1.format(exit_day2);
        }
        wheel_minutes_exit.add("00");
        wheel_minutes_exit.add("15");
        wheel_minutes_exit.add("30");
        wheel_minutes_exit.add("45");

        wheel_picker_exit_date.setData(wheel_dates_exit);
        wheel_picker_exit_hour.setData(wheel_hours_exit);
        wheel_picker_exit_min.setData(wheel_minutes_exit);

        wheel_picker_exit_min.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                exit_min_data = data.toString();
            }
        });
        wheel_picker_exit_hour.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                exit_hour_data = data.toString();
            }
        });
        wheel_picker_exit_date.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                exit_date_data = data.toString();
            }
        });
        //*************************************************************************************
*/
    }
    public void ok_button(View view){

        //nonseleted girince uygulama execute oluyor. Sebebi yukarıdaki setOnItemSelectedListener'lar boş
        //bunu düzelt feature'a ekledim

        if(date.equals(null)||hour_of_selected_day.equals(null)||minute_of_selected_day.equals(null)){
            Toast.makeText(rezervation_activity_with_wheel_time_picker.this,"Please select starting time",Toast.LENGTH_SHORT).show();
        }

        else if(minute_of_selected_day.equals("M") || hour_of_selected_day.equals("H") || date.equals("Pick Date")){
            Toast.makeText(rezervation_activity_with_wheel_time_picker.this,"Please select starting time",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(rezervation_activity_with_wheel_time_picker.this, PayActivity.class);
            intent.putExtra("date",date);
            intent.putExtra("hour_of_day",hour_of_selected_day);
            intent.putExtra("minute_of_day",minute_of_selected_day);
            intent.putExtra("exit_date",exit_date_data);
            intent.putExtra("exit_hour",exit_hour_data);
            intent.putExtra("exit_min",exit_min_data);
            startActivity(intent);

        }

    }
}

