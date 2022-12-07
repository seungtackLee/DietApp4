package com.example.dietapp4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Meal implements Serializable {
//  음식 사진, 음식 이름 및 수량, 음식 소감, 식사 시간, 식사 장소


//    이미지 리소스(주소)
    String image;

//    음식 평
    String foodReview;

//    식사 시간
    Date foodDate = new Date();

//    식사 장소
    String foodLocation;

//    음식 이름 및 수량, ex(김치 볶음밥 한개 - foodName[0]에 김볶, foodNum[0]에 1
    ArrayList<String> foodName;
    ArrayList<Integer> foodNum;


    Meal(){
        this.foodName = new ArrayList<String>();
        this.foodNum = new ArrayList<Integer>();

        this.image = null;
        this.foodReview = null;
        this.foodDate = null;
        this.foodLocation = null;
//        this.foodName.add(foodName);
//        this.foodNum.add(num);


    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFoodName(int index) {
        return foodName.get(index);
    }

    public int getFoodNum(int index) {
        return foodNum.get(index);
    }

//    각 배열에 add
    public void addFood(String foodName, int num){
        this.foodName.add(foodName);
        this.foodNum.add(num);
    }

    public int getFoodArraySize(){
        return foodName.size();
    }


    public String getFoodReview() {
        return foodReview;
    }

    public void setFoodReview(String foodReview) {
        this.foodReview = foodReview;
    }

    public Date getFoodDate() {
        return foodDate;
    }

    public void setFoodDate(Date foodDate) {
        this.foodDate = foodDate;
    }

    public String getFoodLocation() {
        return foodLocation;
    }

    public void setFoodLocation(String foodLocation) {
        this.foodLocation = foodLocation;
    }









}
