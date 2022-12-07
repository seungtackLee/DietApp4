package com.example.dietapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
//    선언
    Button button_submit;
    EditText editText_date, editText_food;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



//        선언
        button_submit = (Button)findViewById(R.id.button_submit);
        editText_date = (EditText)findViewById(R.id.editText_date);
        editText_food = (EditText)findViewById(R.id.editText_food);



//        submit 버튼 누르면
        button_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                페이지 이동
                Intent intent = new Intent(AddActivity.this, MainActivity.class);



//                객체 만들어서 넘기기
                Meal newMeal = new Meal();
                newMeal.addFood("kimchi", 1);


                intent.putExtra("meal", newMeal);


//                페이지 이동
                startActivity(intent);
            }

        });

    }
}