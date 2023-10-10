package com.example.myapplthirdtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPage extends AppCompatActivity {
    private android.widget.Button reservation;
    private android.widget.Button menuButton;
    private Button admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        reservation = (Button) findViewById(R.id.button);

        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReservation();


            }
        });
        admin = (Button) findViewById(R.id.admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogIn();

            }
        });
        menuButton = (Button) findViewById(R.id.openmenuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhairstyleMenu();

            }
        });






    }

    public void openhairstyleMenu() {
        Intent intent = new Intent(this, hairstyleMenu.class);
        startActivity(intent);
    }
    public void openLogIn() {
        Intent intent = new Intent(this,loginPage.class);
        startActivity(intent);
    }
    public void openReservation(){
        Intent intent= new Intent(this,userPageAdd.class);
        startActivity(intent);
    }
}
