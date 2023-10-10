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
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//file://C:/Users/marti/AndroidStudioProjects/MyApplication6/app/src/main/java/com/example/myapplthirdtry/OnActivityResult.java
public class userPageAdd extends AppCompatActivity {

    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page_add);

        addButton = findViewById(R.id.addButton1);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, addActivity.class);
            startActivity(intent);


        });
    }
}