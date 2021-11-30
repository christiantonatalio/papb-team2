package com.example.foodapp.ui.food

import androidx.lifecycle.ViewModel
import com.example.foodapp.helper.FoodData
import com.example.foodapp.model.Food

class FoodViewModel : ViewModel() {

    var listFood = ArrayList<Food>()

    fun getFood(){
        listFood = FoodData.listData
    }
}