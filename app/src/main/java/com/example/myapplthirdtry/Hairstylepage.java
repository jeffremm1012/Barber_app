package com.example.myapplthirdtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;





public class Hairstylepage extends AppCompatActivity {

    private Button taper;
    private Button midfade;
    private Button buzz;

    private Button fringeman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hairstylepage);

        midfade = (Button) findViewById(R.id.midfade);
        midfade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  // a way in order to identify the reservation haircut
                Data.a = 0;

            }
        });
        taper = (Button) findViewById(R.id.taper);
        taper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data.a = 1;

            }
        });
        buzz = (Button) findViewById(R.id.buzz);
        buzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data.a = 2;

            }
        });
        fringeman = (Button) findViewById(R.id.fringeman);
        fringeman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data.a = 3;

            }
        });




    }









    public void openHairstylepage() {
        Intent intent = new Intent(this,Hairstylepage.class);
        startActivity(intent);
    }

}
