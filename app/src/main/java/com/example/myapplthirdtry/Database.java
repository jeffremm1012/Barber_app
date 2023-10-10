package com.example.myapplthirdtry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//file://C:/Users/marti/AndroidStudioProjects/MyApplication6/app/src/main/java/com/example/myapplthirdtry/OnActivityResult.java
public class Database extends AppCompatActivity{

    MyDataBaseHelper MyDB;
    ArrayList<String>  id, name, date, Hairstyle, Time;
    RecyclerView recyclerView;
    FloatingActionButton addButton;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        recyclerView = findViewById(R.id.recyclerView);





        MyDB =  new MyDataBaseHelper(Database.this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        date = new ArrayList<>();
        Hairstyle = new ArrayList<>();
        Time = new ArrayList<>();



        storeDataInArrays();


        // grab data and store it into array, then pass it to customAdapter and then display it in recyclerView
        customAdapter = new CustomAdapter(Database.this,Database.this,id,name,date,Hairstyle,Time);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Database.this));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1){
            //refresh page
            recreate();

        }
    }



    public void openAddActivity(){
        Intent intent = new Intent(this,addActivity.class);
        startActivity(intent);
    }


    public void storeDataInArrays(){
        // store the result from readAllData into a cursor
        Cursor cursor = MyDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "There is no data", Toast.LENGTH_SHORT).show();
        }
        else{
            // read all data from cursor
            while(cursor.moveToNext()){
                //adding data to arrays
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                date.add(cursor.getString(2));
                Hairstyle.add(cursor.getString(3));
                Time.add(cursor.getString(4));
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        //inflate my menu layout
        inflater.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // set up on click listener for menu options
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();


        }
        return super.onOptionsItemSelected(item);
    }
    void confirmDialog() {
        // asks user if they are sure of deleting row
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All");
        builder.setMessage("Are you sure you want to delete it ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDataBaseHelper MyDB = new MyDataBaseHelper(Database.this);
                MyDB.deleteAll();
                //refresh activity
                Intent intent = new Intent(Database.this, Database.class);
                startActivity(intent);

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
