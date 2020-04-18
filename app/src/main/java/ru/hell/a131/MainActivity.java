package ru.hell.a131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inUser;
    private Spinner inDay;
    private Spinner inMonth;
    private Spinner inYear;
    private Button btBlood;
    private Button btStat;
    private Button btSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        init();

        btBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goBlood = new Intent(MainActivity.this, BloodActivity.class);
                String userStr = inUser.getText().toString();
                goBlood.putExtra("name", userStr);
                startActivity(goBlood);
            }
        });

        btStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goStat = new Intent(MainActivity.this, StatisicActivity.class);
                String userStr = inUser.getText().toString();
                goStat.putExtra("name", userStr);
                startActivity(goStat);
            }
        });

        btSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userStr = inUser.getText().toString();
                String brDay = (inDay.getSelectedItem() + " " +  inMonth.getSelectedItem()+ " " +  inYear.getSelectedItem());

                String msgRes = "The patient: " + userStr + "\n" + "Birthday: " + brDay;

                Toast.makeText(MainActivity.this, msgRes, Toast.LENGTH_LONG).show();
            }
        });


        ArrayAdapter<?> arrDay = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);
        arrDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inDay.setAdapter(arrDay);

        ArrayAdapter<?> arrMon = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        arrMon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inMonth.setAdapter(arrMon);

        ArrayAdapter<?> arrYear = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        arrYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inYear.setAdapter(arrYear);


        inDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        inMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        inYear.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));

    }


    private void init(){
        inUser = findViewById(R.id.entUser);
        inDay = findViewById(R.id.spinDay);
        inMonth = findViewById(R.id.spinMon);
        inYear = findViewById(R.id.spinYear);
        btBlood = findViewById(R.id.butBlood);
        btStat = findViewById(R.id.butStat);
        btSv = findViewById(R.id.butSave);

    }
}
