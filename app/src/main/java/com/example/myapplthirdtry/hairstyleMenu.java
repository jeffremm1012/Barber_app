package com.example.myapplthirdtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hairstyleMenu extends AppCompatActivity {
private Button button2;
private Button button3;
private Button button4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hairstylemenu);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHairstylepage();

            }
        });


    }


    public void openFrontPage(){
        Intent intent3 = new Intent(this,FrontPage.class);
        startActivity(intent3);
    }



    public void openWomanHair() {
        Intent intent2 = new Intent(this,Database.class);
        startActivity(intent2);
    }

    public void openHairstylepage() {
        Intent intent = new Intent(this,Hairstylepage.class);
        startActivity(intent);
    }

}