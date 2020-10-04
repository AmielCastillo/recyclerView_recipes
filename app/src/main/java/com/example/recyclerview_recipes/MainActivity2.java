package com.example.recyclerview_recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView recipePic;
    TextView title, ingredients, procedure;

    String data1, data3, data4;
    int myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recipePic = findViewById(R.id.recipePic);
        title = findViewById(R.id.recipeTitle);
        ingredients = findViewById(R.id.recipeIngredients);
        procedure = findViewById((R.id.recipeProcedure));
        getData();
        setData();
    }
    private void getData(){
        if (getIntent().hasExtra("data1") && getIntent().hasExtra("data3") && getIntent().hasExtra("data4") && getIntent().hasExtra("myImage"))
        {
            data1 = getIntent().getStringExtra("data1");
            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");
            myImage = getIntent().getIntExtra("myImage", 1);

        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(data1);
        ingredients.setText("Ingredients: \n"+data3);
        procedure.setText("Procedure: \n" + data4);
        recipePic.setImageResource(myImage);
    }
}