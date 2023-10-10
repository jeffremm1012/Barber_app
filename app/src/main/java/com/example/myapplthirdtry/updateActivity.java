package com.example.myapplthirdtry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {
    EditText nameInput2,dateInput2,Hairstyle2,Time2;
    Button updateButton, deleteButton;

    String id,name, date, hairstyle,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        nameInput2 = findViewById(R.id.nameInput2);
        dateInput2 = findViewById(R.id.ageInput2);
        Hairstyle2 = findViewById(R.id.Hairstyle2);
        Time2 = findViewById(R.id.Time2);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);
        //String.valueOf()




        //First we call the setIntentData and create databasehelper object to update
        getandSetIntentData();
        // set actionbar name after get and set intent data
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }
        updateButton.setOnClickListener(view ->  {
                //Then we can update the data we got from the intent
                MyDataBaseHelper MyDB= new MyDataBaseHelper(updateActivity.this);

                name = nameInput2.getText().toString().trim();
                date = dateInput2.getText().toString().trim();
                hairstyle = Hairstyle2.getText().toString().trim();
                time = Time2.getText().toString().trim();
                MyDB.updateData(id, name,date,hairstyle,time); //This doesnt work
                System.out.println(id + "dumb");

        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call warning system
                confirmDialog();

            }
        });



    }

    public void getandSetIntentData(){
        if(getIntent().hasExtra("name")&& getIntent().hasExtra("age")&&
                getIntent().hasExtra("Hairstyle") && getIntent().hasExtra("Time")){

            // Getting information of the intent data in the String
            id = getIntent().getStringExtra("Id"); // CHECK THIS
            System.out.println(id + "one");
            name = getIntent().getStringExtra("name");
            date = getIntent().getStringExtra("Date (eg DD/MM)");
            hairstyle = getIntent().getStringExtra("Hairstyle");
            time = getIntent().getStringExtra("Time");
            System.out.println(name + "," + date + "," + hairstyle + "," + time);


            //Setting intent data
            nameInput2.setText(name);

            dateInput2.setText(date);
            Hairstyle2.setText(hairstyle);
            Time2.setText(time);


        }
        else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        // asks user if they are sure of deleting row
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete" + name + " 's Reservation ?");
        builder.setMessage("Are you sure you want to delete it ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //initialise class
                MyDataBaseHelper MyDB = new MyDataBaseHelper(updateActivity.this);
                // makes it possible to access method
                MyDB.deleteRow(id);

                //sends user back to schedule
                finish();

                
            }
        });
        builder.setNegativeButton("Go back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}