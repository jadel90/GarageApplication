package com.example.a011;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {

    Context context;
    ImageView img;
    TextView tv1, tv2;




    FloatingActionButton fab1, fab2, fab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img = findViewById(R.id.img);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);




        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);




        Intent intent = getIntent();


        String name = intent.getExtras().getString("name");
        String price = intent.getExtras().getString("price");
        int image = intent.getExtras().getInt("image", 0);




        // NEW CODE: display ad.
        String ad = intent.getExtras().getString("ad");




        tv1.setText(name);
        tv2.setText(price);
        img.setImageResource(image);








//        car web page
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri uri_fab1 = Uri.parse(ad);
                Intent intent_fab1 = new Intent(Intent.ACTION_VIEW, uri_fab1);
                startActivity(intent_fab1);


            }
        });






        //back button = MainActivity2
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                context.startActivity(intent);
            }
        });






        //home button = MainActivity
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);




            }
        });



    }
}