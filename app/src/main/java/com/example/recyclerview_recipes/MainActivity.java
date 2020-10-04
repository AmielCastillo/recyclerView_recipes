package com.example.recyclerview_recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String s1[], s2[];
    int images[] = {R.drawable.bacon_spinach_stuffed_chicken, R.drawable.tex_mex_meatballs, R.drawable.calzone, R.drawable.spaghetti, R.drawable.beef_tacos, R.drawable.beef_totchos};
    private RecyclerView recyclerView;
    private RecipeListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = getResources().getStringArray(R.array.recipeNames);
        s2 = getResources().getStringArray(R.array.recipeDescriptions);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecipeListAdapter(this, s1, s2, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}