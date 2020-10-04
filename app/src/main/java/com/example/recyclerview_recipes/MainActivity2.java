package com.example.recyclerview_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView recipePic;
    TextView title, information;

    String data1, data2;
    int myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recipePic = findViewById(R.id.recipePic);
        title = findViewById(R.id.recipeTitle);
        information = findViewById(R.id.recipeInformation);
        getData();
        setData();
    }
    private void getData(){
        if (getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("myImage"))
        {
            data1 = getIntent().getStringExtra("data1");
            myImage = getIntent().getIntExtra("myImage", 1);

        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(data1);
        information.setText("Ingredients...\n- filler text\n- filler text\n- filler text\n\nProcedure...\n- filler text\n- filler text\n- filler text");
        recipePic.setImageResource(myImage);
    }
}