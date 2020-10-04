package com.example.recyclerview_recipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {
    String data1[], data2[], data3[], data4[];
    int images[];
    Context context;
    private final LayoutInflater inflater;
    public RecipeListAdapter(Context c, String[] s1, String[] s2, String[] s3, String[] s4, int img[]){
        context = c;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        images = img;
        inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myItemView = inflater.inflate(R.layout.recipelist_item, parent,false);
        return new MyViewHolder(myItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.recipeName.setText(data1[position]);
        holder.recipeDescription.setText(data2[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("data4", data4[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView recipeName, recipeDescription;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView, RecipeListAdapter recipeListAdapter) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipeName1);
            recipeDescription = itemView.findViewById(R.id.recipeDescription1);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
