package com.example.dietapp4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    선언
    RecyclerView myRecyclerView;
    LinearLayoutManager myLayoutManager;
    FloatingActionButton button_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//      선언
        button_add = (FloatingActionButton)findViewById(R.id.button_add);




//      add버튼 누르면 페이지 이동
        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });







//      리사이클러 뷰 (리스트뷰에서 바꿈)
        myRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        ArrayList<Meal> mealList = new ArrayList<>();


        //      예시 데이터 추가
        if(mealList.size()==0) {
            mealList.add(new Meal("testDate1", "testFood1"));
            mealList.add(new Meal("testDate2", "testFood2"));
            mealList.add(new Meal("testDate3", "testFood3"));
        }

//        어댑터 연결
        MyAdapter myAdapter = new MyAdapter(mealList);
        myRecyclerView.setAdapter(myAdapter);



        //      객체 받아서 객체 리스트에 add, 추가 후에 추가 페이지에서 뒤로가기 했을 때 생기는지 확인해야 함
        Intent getIntent = getIntent();
        if(getIntent.hasExtra("meal")){
            Meal newMeal2 = (Meal)getIntent.getSerializableExtra("meal");
            mealList.add(newMeal2);
        }



    }




}