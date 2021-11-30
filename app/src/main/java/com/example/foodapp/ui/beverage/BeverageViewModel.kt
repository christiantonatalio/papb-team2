package com.example.foodapp.ui.beverage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.helper.BeverageData
import com.example.foodapp.model.Beverage

class BeverageViewModel : ViewModel()
{
    var listBeverages = ArrayList<Beverage>()

    fun getBeverages(){
        listBeverages = BeverageData.listData
    }

}