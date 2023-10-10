package com.example.myapplthirdtry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class addActivity extends AppCompatActivity {
    EditText nameInput, dateInput, Hairstyle, Time;
    Button reserveButton;
    private TextView text, text2;
    private Button cbutton, tbutton;

    ArrayList<String> hourList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameInput = findViewById(R.id.nameInput);

        Hairstyle = findViewById(R.id.Hairstyle);


        text = findViewById(R.id.text1);
        cbutton = findViewById(R.id.calenderbutton);

        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();


            }
        });

        text2 = findViewById(R.id.timetext);
        tbutton = findViewById(R.id.tbutton);

        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTime();


            }
        });
    }


    private void openDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {


                 if (day < 10 && month < 10) {
                     String dayWith0 = String.format("%02d", day);
                     String monthWith0 = String.format("%02d", month + 1);
                     String date1 = dayWith0 + "/" + monthWith0 + "/" + String.valueOf(year);
                     text.setText(date1);
                 }
                else if(month < 10){
                    String monthWith0 = String.format("%02d", month +1);
                    String date1 = String.valueOf(day) + "/" + monthWith0 + "/" + String.valueOf(year);
                    text.setText(date1);
                }
                else if (day < 10) {
                    String dayWith0 = String.format("%02d", day);
                    String date1 = dayWith0 + "/" + String.valueOf(month+1) + "/" + String.valueOf(year);
                    text.setText(date1);

                }
                else {
                    String date1 = String.valueOf(day) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                    text.setText(date1);

                }




            }
        }, 2023, 9, 8);
        dialog.show();
    }

    private void openTime() {
        TimePickerDialog time = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                String minWith0 = String.valueOf(min) + "0";
                String minWith02= String.format("%02d",min);
                String hourWith0 = String.format("%02d",hour);
                if(min < 10 && hour < 10){
                    if(min != 0){
                        text2.setText(hourWith0 + ":" + minWith02);
                    }
                    else{
                        text2.setText(hourWith0+ ":" + minWith0);
                    }







                }
                else if(min < 10){
                    if(min != 0){
                        text2.setText(String.valueOf(hour) + ":" + minWith02);

                    }
                    else{
                        text2.setText(String.valueOf(hour) + ":" + minWith0);
                    }


                }
                else if (hour < 10 ) {
                    text2.setText(hourWith0+ ":" + String.valueOf(min));


                }
                else{
                    text2.setText(String.valueOf(hour)+ ":" + String.valueOf(min));
                }


            }
        }, 0, 0, true);

        time.show();


        reserveButton = findViewById(R.id.reserveButton);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameCheck = nameInput.getText().toString();
                String hairCheck = Hairstyle.getText().toString();
                String dateCheck = text.getText().toString();
                String timeCheck = text2.getText().toString();
                String time = timeCheck.substring(0,2);
                boolean datetimeCheck = false;
                for(int i = 0; i< hourList.size();i++) {
                    if ((timeCheck).equals(hourList.get(i))) {
                        datetimeCheck = true;
                    }
                }


                if (nameCheck.matches("") || hairCheck.matches("") ||
                        dateCheck.matches("") || timeCheck.matches("")) {
                    Toast.makeText(addActivity.this, "More info needed", Toast.LENGTH_SHORT).show();


                }
                if(datetimeCheck == true|| hourList.isEmpty()== false){
                    Toast.makeText(addActivity.this, "time taken", Toast.LENGTH_SHORT).show();
                }








                    if(Integer.valueOf(time)< 9 || Integer.valueOf(time)> 19) {
                        Toast.makeText(addActivity.this, "Closed time", Toast.LENGTH_SHORT).show();
                    }


                    else{
                           // make condition for same date
                        /*
                                hourList.add(time);
                               for(int i = 0; i< hourList.size();i++){
                                   for(int j = i+1; i<hourList.size();j++){
                                       if ((hourList.get(i)).equals(hourList.get(j)))
                                       {
                                           Toast.makeText(addActivity.this, "time is taken", Toast.LENGTH_SHORT).show();

                                       }
                                       else{

                         */

                                           MyDataBaseHelper myDB = new MyDataBaseHelper(addActivity.this);
                                           myDB.addReservation(nameInput.getText().toString().trim(),
                                                   text.getText().toString().trim(),
                                                   Hairstyle.getText().toString().trim(),
                                                   text2.getText().toString().trim());
                                           hourList.add(timeCheck);
                                                    openMenu();
                                       }

                               }










        });


    }
    public void openMenu(){
        Intent intent= new Intent(this,FrontPage.class);
        startActivity(intent);
    }

}

