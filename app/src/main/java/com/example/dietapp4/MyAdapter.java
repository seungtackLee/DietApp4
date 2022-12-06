package com.example.dietapp4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        ImageView picture;
        TextView text_date;
        TextView text_food;

        MyViewHolder(View view) {
            super(view);
//            picture = (ImageView)view.findViewById(R.id.item_imageView);
            text_date = view.findViewById(R.id.item_textView_date);
            text_food = view.findViewById(R.id.item_textView_food);
        }
    }

    ArrayList<Meal> myMealList;

    MyAdapter(ArrayList<Meal> meals){
            this.myMealList = meals;
        }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

//            myViewHolder.picture.setImageResource(myMealList.get(position).getImageID());

        myViewHolder.text_date.setText(myMealList.get(position).getDate());
        myViewHolder.text_food.setText(myMealList.get(position).getFood());
//            myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() { @Override
//            public void onClick(View v) {
//                Context context = v.getContext();
//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(mySchoolList.get(position).getURL())); context.startActivity(intent);
//            } });


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);

//                int position = myViewHolder.getAdapterPosition();
                Meal clickMeal = (Meal) myMealList.get(position);
                intent.putExtra("meal", clickMeal);

                context.startActivity(intent);


        } });

    }

    @Override
    public int getItemCount() {
        return myMealList.size();
    }




}
