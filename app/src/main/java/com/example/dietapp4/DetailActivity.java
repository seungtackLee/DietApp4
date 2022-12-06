package com.example.dietapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);





//        intent와 함께 받은 객체 텍스트 뷰에 표시

        Intent getIntent = getIntent();


        if(getIntent.hasExtra("meal")){
            Meal newMeal = (Meal)getIntent.getSerializableExtra("meal");

            //        선언
            TextView detail_date, detail_food;
            detail_date = (TextView)findViewById(R.id.textView_date_detail);
            detail_food = (TextView)findViewById(R.id.textView_food_detail);


            detail_date.setText(newMeal.getDate());
            detail_food.setText(newMeal.getFood());
        }


    }
}