package com.example.fragment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;


public class rili extends Activity {
    DatePicker datePicker;
    TimePicker timePicker;
    TextView textView;
    EditText editText;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.rili);
        datePicker=findViewById(R.id.datePicker);
        timePicker=findViewById(R.id.timePicker);
//        textView=findViewById(R.id.textview);
        editText=findViewById(R.id.editText);
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);
        datePicker.init(year,month,day,new DatePicker.OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                rili.this.year=i;
                rili.this.month=i1;
                rili.this.day=i2;
                showDate(year,month,day,hour,minute);
            }
        });
        timePicker.setEnabled(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                rili.this.hour=i;
                rili.this.minute=i1;
                showDate(year,month,day,hour,minute);
            }
        });

    }
    private void showDate(int year,int month,int day,int hour,int minute){
        editText.setText("您的购买日期是"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分");
    }
}