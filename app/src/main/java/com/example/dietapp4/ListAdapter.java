package com.example.dietapp4;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    public static ArrayList<Meal> items = new ArrayList<Meal>();
    Context context;

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public Meal getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        Meal listItem = items.get(position);

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }



//        listview_item.xml의 textView_date에 textView_date 표시
        TextView textView_date = convertView.findViewById(R.id.textView_date);
        TextView textView_food = convertView.findViewById(R.id.textView_food);

        textView_food.setText(listItem.getFood());
        textView_date.setText(listItem.getDate());



        return convertView;
    }

    public void addItem(Meal newMeal){
        items.add(newMeal);
    }






}
