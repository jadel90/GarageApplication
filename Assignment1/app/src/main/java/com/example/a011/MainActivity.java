package com.example.a011;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public static final String VEHICLE_TYPE = "vehicle_type";


    // Define a placeholder for the selected vehicle type
    private int selectedVehicleType = -1;


    int selectedRadioButtonId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // set background color
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ADD8E6"));




        // radiobutton initialise
        RadioButton rdb1 = findViewById(R.id.rbCar);
        RadioButton rdb2 = findViewById(R.id.rdbBike);
        RadioButton rdb3 = findViewById(R.id.rdbOther);




        // Initialize UI elements
        RadioGroup radioGroupOptions = findViewById(R.id.rdGroup);
        Button continueButton = findViewById(R.id.btn_next);






        // Check if any radio button is selected
        int vehicleType = getIntent().getIntExtra(VEHICLE_TYPE, -1);
        if (radioGroupOptions.getCheckedRadioButtonId() == -1) {
            // No radio button is selected, show a Toast
            Toast.makeText(this, "No radio button clicked", Toast.LENGTH_LONG).show();
        }




        // Set click listener for the Continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                int selectedRadioButtonId = radioGroupOptions.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);




                if (selectedRadioButtonId == -1) {
                    // No radio button is selected, show a Toast or handle the case as needed
                    Toast.makeText(MainActivity.this, "Please select a vehicle type", Toast.LENGTH_SHORT).show();
                } else {
                    // A radio button is selected
                    String selectedOption = selectedRadioButton.getText().toString();


                    if (selectedOption.equals("Car")) {
                        // Car
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra(VEHICLE_TYPE, "Car");
                        startActivity(intent);
                    }
                    else if (selectedOption.equals("Bike")) {
                        // Bike
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra(VEHICLE_TYPE, "Bike");
                        startActivity(intent);
                    }
                    else if (selectedOption.equals("Others")) {
                        // Others
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra(VEHICLE_TYPE, "Others");
                        startActivity(intent);
                    }
                }
            }
        });






    }
}