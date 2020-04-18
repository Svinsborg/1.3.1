package ru.hell.a131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StatisicActivity extends AppCompatActivity {

    private Bundle userName;
    private TextView setName;
    private EditText weight;
    private EditText steps;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        init();

        final String userStr = userName.get("name").toString();
        setName.setText(userStr);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weightDl = 0;
                int stepsInt = 0;

                String weightStr = weight.getText().toString();

                try {
                    weightDl = Double.parseDouble(weightStr);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(StatisicActivity.this, "Weight: Insert the number", Toast.LENGTH_SHORT).show();
                }

                String stepsStr = steps.getText().toString();

                try {
                    stepsInt = Integer.parseInt(stepsStr);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(StatisicActivity.this, "Steps: Insert the number", Toast.LENGTH_SHORT).show();
                }

                String msgRes = "The patient: " + userStr + "\n"
                        + "Weight: " + weightDl + "\n"
                        + "Steps: " + stepsInt ;

                Toast.makeText(StatisicActivity.this, msgRes, Toast.LENGTH_LONG).show();
                // finish();


            }
        });
    }

    private void init() {

        setName = findViewById(R.id.swUser);
        userName = getIntent().getExtras();
        weight = findViewById(R.id.editWeight);
        steps = findViewById(R.id.editStep);
        save = findViewById(R.id.butSaveStat);

    }


}
