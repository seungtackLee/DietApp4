package com.example.dietapp4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
//    선언
    ListView listView;
    ListAdapter adapter;
    FloatingActionButton button_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//      선언
        listView = (ListView) findViewById(R.id.mealListView);
        adapter = new ListAdapter();
        button_add = (FloatingActionButton)findViewById(R.id.button_add);



//      예시 데이터 추가
        if(adapter.getCount()==0) {
            adapter.addItem(new Meal("testDate1", "testFood1"));
            adapter.addItem(new Meal("testDate2", "testFood2"));
            adapter.addItem(new Meal("testDate3", "testFood3"));
        }



//        리스트 뷰 setAdapter
        listView.setAdapter(adapter);



//      add버튼 누르면 페이지 이동
        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });



//      객체 받아서 객체 리스트에 add, 추가 후에 추가 페이지에서 뒤로가기 했을 때 생기는지 확인해야 함
        Intent getIntent = getIntent();
        if(getIntent.hasExtra("meal")){
            Meal newMeal2 = (Meal)getIntent.getSerializableExtra("meal");
            adapter.addItem(newMeal2);
        }



        //        리스트뷰 누르면
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                position이 해당 리스트의 인덱스, id도 동일한 인덱스 값
                Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);

                intent2.putExtra("meal", (Meal)adapter.getItem(position));


                startActivity(intent2);
            }
        });



    }





}