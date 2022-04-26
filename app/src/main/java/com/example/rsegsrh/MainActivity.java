package com.example.rsegsrh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        EditText employeeName, employeeHours;
        RadioGroup radioGroup;
        RadioButton btnSelected;
        Button Calculate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                //EditText
                employeeName = findViewById(R.id.name);
                employeeHours = findViewById(R.id.Hours);
                //RadioGroup
                radioGroup = findViewById(R.id.radioGroup);
                //Button
                Calculate = findViewById(R.id.Calculate);
                //button On click listener
                Calculate.setOnClickListener(this);
        }

        public void onClick(View v) {


                if (v.getId() == R.id.Calculate) {
                        int selectedEmployeeType = radioGroup.getCheckedRadioButtonId();

                        Calculate = findViewById(selectedEmployeeType);

                        String type = Calculate.getText().toString();

                        String name = employeeName.getText().toString();
                        String totalHours = ( employeeHours.getText().toString() );

                        Intent intent = new Intent(this, MainActivity2.class);

                        intent.putExtra("type", type);
                        intent.putExtra("empName", name);
                        intent.putExtra("hours", totalHours);
                        startActivity(intent);
                }
        }
}