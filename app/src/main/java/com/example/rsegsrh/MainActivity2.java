package com.example.rsegsrh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView txtHours;
    TextView txtTotalWage;
    TextView txtRegularWage;
    TextView txtOvertimeWage;
    TextView txtOverTimeHours;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtHours = findViewById(R.id.TotalHoursRenderedNumber);
        txtTotalWage = findViewById(R.id.TotalRegularWageNumber);
        txtRegularWage = findViewById(R.id.TotalWageReceivedNumber);
        txtOvertimeWage = findViewById(R.id.TotalOvertimeWageNumber);
        txtOverTimeHours = findViewById(R.id.TotalOvertimeHoursNumber);

        Button btnback = findViewById(R.id.backbutton);
        btnback.setOnClickListener(this);


        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtHours.setText(String.valueOf(EmployeeHours));
        calcWage(EmployeeType, EmployeeHours, txtTotalWage, txtRegularWage,txtOverTimeHours);


    }

    @SuppressLint("SetTextI18n")
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtRegularWage, TextView txtOTWage) {
        double totalWage = 0.0;
        double totalOTWage = 0.0;

        switch (employeeType) {
            case "Regular Employee":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 115) + 800;
                    totalOTWage = employeeHours * 115;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱800");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 100;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Part-Time Worker":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 90) + 600;
                    totalOTWage = employeeHours * 90;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱600");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 75;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Probationary Employee":
                if (employeeHours > 8.0) {
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 100) + 720;
                    totalOTWage = employeeHours * 100;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱720");
                    txtOTWage.setText("₱" + totalOTWage);
                } else {
                    totalWage = employeeHours * 90;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
        }
    }


    public void onClick(@NonNull View v) {
        if (v.getId() == R.id.backbutton) {
            startActivity(new Intent(MainActivity2.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}