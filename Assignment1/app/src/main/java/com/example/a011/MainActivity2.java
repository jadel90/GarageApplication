package com.example.a011;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Car> arrayList = new ArrayList<>();
    FloatingActionButton fab;








    String[] car_name;
    String[] bike_name;
    String[] other_name;








    String[] car_price;
    String[] bike_price;
    String[] other_price;




    // NEW CODE
    String[] car_ad;
    String[] bike_ad;
    String[] other_ad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // Initialize UI elements
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.fab);








        // Get the selected vehicle type from the intent
        String vehicleType = getIntent().getStringExtra(MainActivity.VEHICLE_TYPE);
        //  Log.e("MainActivity2", "Received vehicle type: " + vehicleType);  // Debug line
        //Toast.makeText(this,vehicleType,Toast.LENGTH_SHORT).show();








        // Initialize arrays based on the selected vehicle type
        if ("Car".equals(vehicleType)) {
            car_name = getResources().getStringArray(R.array.car_names);
            car_price = getResources().getStringArray(R.array.car_prices);
            car_ad = getResources().getStringArray(R.array.car_ads);
        }




        else if ("Bike".equals(vehicleType)) {
            bike_name = getResources().getStringArray(R.array.bike_names);
            bike_price = getResources().getStringArray(R.array.bike_prices);
            bike_ad = getResources().getStringArray(R.array.bike_ads);
        }




        else if ("Others".equals(vehicleType)) {
            other_name = getResources().getStringArray(R.array.other_names);
            other_price = getResources().getStringArray(R.array.other_prices);
            other_ad = getResources().getStringArray(R.array.other_ads);
        }




        else {
            // Handle an unknown or missing vehicle type here.
            return;
        }








        // Populate the array list with data based on the selected vehicle type
        switch (vehicleType) {
            case "Car":
                arrayList.add(new Car(R.drawable.car1, car_name[0], car_price[0], car_ad[0] ));
                arrayList.add(new Car(R.drawable.car2, car_name[1], car_price[1], car_ad[1] ));
                arrayList.add(new Car(R.drawable.car3, car_name[2], car_price[2], car_ad[2] ));
                arrayList.add(new Car(R.drawable.car4, car_name[3], car_price[3], car_ad[3] ));
                arrayList.add(new Car(R.drawable.car5, car_name[4], car_price[4], car_ad[4] ));
                arrayList.add(new Car(R.drawable.car6, car_name[5], car_price[5], car_ad[5] ));
                break;








            case "Bike":
                arrayList.add(new Car(R.drawable.bike1, bike_name[0], bike_price[0], bike_ad[0] ));
                arrayList.add(new Car(R.drawable.bike2, bike_name[1], bike_price[1], bike_ad[1] ));
                arrayList.add(new Car(R.drawable.bike3, bike_name[2], bike_price[2], bike_ad[2] ));
                arrayList.add(new Car(R.drawable.bike4, bike_name[3], bike_price[3], bike_ad[3] ));
                arrayList.add(new Car(R.drawable.bike5, bike_name[4], bike_price[4], bike_ad[4] ));
                arrayList.add(new Car(R.drawable.bike6, bike_name[5], bike_price[5], bike_ad[5] ));
                break;








            case "Others":
                arrayList.add(new Car(R.drawable.other1, other_name[0], other_price[0], other_ad[0] ));
                arrayList.add(new Car(R.drawable.other2, other_name[1], other_price[1], other_ad[1] ));
                arrayList.add(new Car(R.drawable.other3, other_name[2], other_price[2], other_ad[2] ));
                arrayList.add(new Car(R.drawable.other4, other_name[3], other_price[3], other_ad[3] ));
                arrayList.add(new Car(R.drawable.other5, other_name[4], other_price[4], other_ad[4] ));
                arrayList.add(new Car(R.drawable.other6, other_name[5], other_price[5], other_ad[5] ));
                break;
        }








        // Display Recycler View
        CarRecycler carRecycler = new CarRecycler(this, arrayList, fab);
        recyclerView.setAdapter(carRecycler);








        Log.e("MainActivity2", "Car ArrayList size: " + arrayList.size());








        FloatingActionButton fabCall = findViewById(R.id.fab2);








        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "35383456789"));
                startActivity(intent);
            }
        });




    }
}