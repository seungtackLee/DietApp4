package com.example.dietapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
//    선언
    TextView textView_date_detail, textView_food_detail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


//        선언
        textView_date_detail = (TextView)findViewById(R.id.textView_date_detail);
        textView_date_detail = (TextView)findViewById(R.id.textView_food_detail);



//        intent와 함께 받은 객체 텍스트 뷰에 표시
        Intent getIntent = getIntent();
        if(getIntent.hasExtra("meal")){
            Meal newMeal = (Meal)getIntent.getSerializableExtra("meal");

            textView_date_detail.setText(newMeal.getDate());
            textView_food_detail.setText(newMeal.getFood());
        }
    }
}