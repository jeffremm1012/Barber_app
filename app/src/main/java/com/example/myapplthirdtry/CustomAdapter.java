package com.example.myapplthirdtry;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
    private Activity activity;
    private ArrayList id, name,date, Hairstyle,Time;
     int position;


    CustomAdapter(Activity activity,Context context,
                  ArrayList id,
                  ArrayList name,
                  ArrayList date,
                  ArrayList Hairstyle,
                  ArrayList Time){

        this.activity = activity;
        this.context = context;
        this.id= id;
        this.name = name;
        this.date = date;
        this.Hairstyle = Hairstyle;
        this.Time = Time;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // pass our row layout
        LayoutInflater inflater = LayoutInflater.from(context);
         View view =inflater.inflate(R.layout.my_row,parent,false);
         return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //set all values of text by getting the data from the arrays
        this.position = position;

        holder.idtext.setText(String.valueOf(id.get(position)));
        holder.nametxt.setText(String.valueOf(name.get(position)));


        System.out.println(date);
//LINEAR SORT !!!!!!!!!!!!!!!!!!
    for (int i = 0; i < date.size(); i++) {



            // Inner nested loop pointing 1 index ahead
        for (int j = i + 1; j < date.size(); j++) {
            Object times = date.get(i);
            Object timeDay = Time.get(i);

            Object change = date.get(j);
            Object change_2 = name.get(j);
            Object change_3 = Hairstyle.get(j);
            Object change_4 = Time.get(j);


            String times_2 = times.toString();
            String year = times_2.substring(6, 10);
            String month = times_2.substring(3, 5);
            String day = times_2.substring(0, 2);


            Object times_3 = date.get(j);
            String times_4 = times_3.toString();
            String year_2 = times_4.substring(6, 10);
            String month_2 = times_4.substring(3, 5);
            String day_2 = times_4.substring(0, 2);
//min and hours
            String timeDay_2 = timeDay.toString();
            String hours = timeDay_2.substring(0, 2);
            String minutes = timeDay_2.substring(3, 5);

            Object timeDay_3 = Time.get(j);
            String timeDay_4 = timeDay_3.toString();
            String hours_2 = timeDay_4.substring(0, 2);
            String minutes_2 = timeDay_4.substring(3, 5);



// error any time before can be booked, also two at same time
            if (Integer.valueOf(year_2) < Integer.valueOf(year)) {


                date.set((j), date.get(i)); // instead of set, change index
                date.set((i), change);
                name.set((j), name.get(i)); // instead of set, change index
                name.set((i), change_2);
                Hairstyle.set((j), Hairstyle.get(i));
                Hairstyle.set((i), change_3);
                Time.set((j), Time.get(i));
                Time.set((i), change_4);


            } else if (Integer.valueOf(month_2) < Integer.valueOf(month)) {


                date.set((j), date.get(i)); // instead of set, change index
                date.set((i), change);
                name.set((j), name.get(i)); // instead of set, change index
                name.set((i), change_2);
                Hairstyle.set((j), Hairstyle.get(i));
                Hairstyle.set((i), change_3);
                Time.set((j), Time.get(i));
                Time.set((i), change_4);


            }

            else if (Integer.valueOf(day_2) < Integer.valueOf(day)) {


                date.set((j), date.get(i)); // instead of set, change index
                date.set((i), change);
                name.set((j), name.get(i)); // instead of set, change index
                name.set((i), change_2);
                Hairstyle.set((j), Hairstyle.get(i));
                Hairstyle.set((i), change_3);
                Time.set((j), Time.get(i));
                Time.set((i), change_4);


            }


            /*
            else if (Integer.valueOf(hours_2) < Integer.valueOf(hours)) {
                date.set((j), date.get(i)); // instead of set, change index
                date.set((i), change);
                name.set((j), name.get(i)); // instead of set, change index
                name.set((i), change_2);
                Hairstyle.set((j), Hairstyle.get(i));
                Hairstyle.set((i), change_3);
                Time.set((j), Time.get(i));
                Time.set((i), change_4);




            }

            else if (Integer.valueOf(minutes_2) < Integer.valueOf(minutes)) {


                date.set((j), date.get(i)); // instead of set, change index
                date.set((i), change);
                name.set((j), name.get(i)); // instead of set, change index
                name.set((i), change_2);
                Hairstyle.set((j), Hairstyle.get(i));
                Hairstyle.set((i), change_3);
                Time.set((j), Time.get(i));
                Time.set((i), change_4);


            }

             */
        }





    }


        holder.datetxt.setText(String.valueOf(date.get(position)));
        holder.Hairstyletxt.setText(String.valueOf(Hairstyle.get(position)));
        holder.Timetxt.setText(String.valueOf(Time.get(position)));
//HERE IS THE SOLUTION

        // when user clicks the info he put in is displayed
        holder.updateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,updateActivity.class);
                intent.putExtra("Id",String.valueOf(id.get(position)));

                intent.putExtra("name",String.valueOf(name.get(position)));
                intent.putExtra("date",String.valueOf(date.get(position)));
                intent.putExtra("Hairstyle",String.valueOf(Hairstyle.get(position)));
                intent.putExtra("Time",String.valueOf(Time.get(position)));
                activity.startActivityForResult(intent,1);
                //transfer data to new activity

            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idtext,nametxt, datetxt,Hairstyletxt,Timetxt;
        LinearLayout updateLayout;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //get id of those TextView

            idtext = itemView.findViewById(R.id.idText);
            nametxt = itemView.findViewById(R.id.nameText);
            datetxt = itemView.findViewById(R.id.dateText);
            Hairstyletxt = itemView.findViewById(R.id.hairstyleText);
            Timetxt = itemView.findViewById(R.id.TimeText);
            updateLayout = itemView.findViewById(R.id.updateLayout);
        }

    }
}
