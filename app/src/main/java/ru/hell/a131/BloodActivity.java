package ru.hell.a131;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BloodActivity extends AppCompatActivity {

    private List<Blood> parametrs = new ArrayList<>();

    private Bundle userName;
    private TextView setName;
    private EditText pressUp ;
    private EditText pressDw ;
    private EditText pulse ;
    private CheckBox tch ;
    private Button btSvBl;
    private TextView editTextDate;
    private TextView editTextTime;
    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);

        init();
        final String userStr = userName.get("name").toString();
        setName.setText(userStr);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDatePicker();
            }
        });

        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTimePicker();
            }
        });

        btSvBl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int upper = 0;
                int down = 0;
                int pulseInt = 0;

                String prUp = pressUp.getText().toString();

                try {
                    upper = Integer.parseInt(prUp);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(BloodActivity.this, "Upper: Insert the number", Toast.LENGTH_SHORT).show();
                }

                String prDw = pressDw.getText().toString();

                try {
                    down = Integer.parseInt(prDw);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(BloodActivity.this, "Down: Insert the number", Toast.LENGTH_SHORT).show();
                }

                String pul = pulse.getText().toString();

                try {
                    pulseInt = Integer.parseInt(pul);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(BloodActivity.this, "Pulse: Insert the number", Toast.LENGTH_SHORT).show();
                }

                boolean tach = tch.isChecked();

                Date date = (Date) editTextDate.getText();
                Time time = (Time) editTextTime.getText();

                String msgRes = "The patient: " + userStr + "\n"
                                + "Upper: " + upper + "\n"
                                + "Down: " + down + "\n"
                                + "Pulse: " + pulseInt + "\n"
                                + "Tachycardia: " + tach
                                + "Date/time: " + date + "/" + time;

                Toast.makeText(BloodActivity.this, msgRes, Toast.LENGTH_LONG).show();

                parametrs.add(new Blood(upper, down, pulseInt, tach, date, time));

                //finish();
            }
        });
    }




    private void init() {

        btSvBl = findViewById(R.id.butSaveBl);
        setName = findViewById(R.id.swUser);
        userName = getIntent().getExtras();
        editTextDate = findViewById(R.id.entDate);
        editTextTime = findViewById(R.id.entTime);
        pressUp = findViewById(R.id.editUp);
        pressDw = findViewById(R.id.editDw);
        pulse = findViewById(R.id.editPl);
        tch = findViewById(R.id.checkTach);
    }

    private void callDatePicker() {

        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        editTextDate.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void callTimePicker() {

        final Calendar cal = Calendar.getInstance();
        mHour = cal.get(Calendar.HOUR_OF_DAY);
        mMinute = cal.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String editTextTimeParam = hourOfDay + " : " + minute;
                        editTextTime.setText(editTextTimeParam);
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

}
