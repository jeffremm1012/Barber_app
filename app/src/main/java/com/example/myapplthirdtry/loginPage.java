package com.example.myapplthirdtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {
    private EditText Username, Password;
    private Button loginButton;
    private static String validUsername;
    private static String validPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Username = (EditText) findViewById(R.id.Username);
        loginButton = (Button) findViewById(R.id.loginButton);
        Password = (EditText) findViewById(R.id.Password);
        validUsername = "hp";
        validPassword= "234";
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(Username.getText()).equals(validUsername) && String.valueOf(Password.getText()).equals(validPassword)){
                    Toast.makeText(loginPage.this, "true", Toast.LENGTH_SHORT).show();
                    openDatabase();




                }
                else{
                    Toast.makeText(loginPage.this, "no", Toast.LENGTH_SHORT).show();
                }

            }
        });

        }


    public void openDatabase() {
        Intent intent = new Intent(this, Database.class);
        startActivity(intent);


    }

}