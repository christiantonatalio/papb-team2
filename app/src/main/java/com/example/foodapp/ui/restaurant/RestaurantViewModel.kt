package com.example.foodapp.ui.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.helper.RestaurantData
import com.example.foodapp.model.Restaurant

class RestaurantViewModel : ViewModel() {

    var listRestaurant = ArrayList<Restaurant>()

    fun getRestaurant(){
        listRestaurant = RestaurantData.listData
    }
}