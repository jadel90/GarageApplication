package com.example.a011;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CarRecycler  extends RecyclerView.Adapter<CarRecycler.ViewHolder> {


    Context context;
    ArrayList<Car> arrayList = new ArrayList<>();
    FloatingActionButton fab;






    public CarRecycler(Context context, ArrayList<Car>arrayList, FloatingActionButton fab) {
        this.context = context;
        this.arrayList = arrayList;
        this.fab = fab;
    }




    @NonNull
    @Override
    public CarRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CarRecycler.ViewHolder holder, int position) {




        // Bind common data
        // RecyclerView: MainActivity2. card_view.xml
        // Display image, car name, car price into recyclerview.
        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.textView1.setText(arrayList.get(position).getName());
        holder.textView2.setText(arrayList.get(position).getPrice());


        // when click on image, display image, car name, car price, car ad.
        // set a click listener on the image
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(context, "Car" + position, Toast.LENGTH_LONG).show();


                Intent intent = new Intent(view.getContext(), MainActivity3.class);


                intent.putExtra("image", arrayList.get(position).getImage());
                intent.putExtra("name", arrayList.get(position).getName());
                intent.putExtra("price", arrayList.get(position).getPrice());
                intent.putExtra("ad", arrayList.get(position).getAd());


                context.startActivity(intent);


            }
        });






        // Set a click listener on the FAB
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle FAB click action here




                // Start a new activity
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);


                // For example, display a Toast
                Toast.makeText(context, "FAB Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }










    @Override
    public int getItemCount() {


        return arrayList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            cardView = itemView.findViewById(R.id.cardView);


        }




    }



}
