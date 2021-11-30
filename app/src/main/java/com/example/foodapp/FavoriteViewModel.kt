package com.example.foodapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.Beverage
import com.example.foodapp.room.FoodAppDao
import com.example.foodapp.room.FoodAppDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteViewModel(application: Application) : ViewModel() {
    private val mfoodAppDao: FoodAppDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FoodAppDatabase.getInstance(application)
        mfoodAppDao = db.foodAppDao
    }

    fun getBeverage(): LiveData<ArrayList<Beverage>> = mfoodAppDao.getBeverage()

    fun insertBeverage(beverage: Beverage){
        executorService.execute{ mfoodAppDao.insertBeverage(beverage) }
    }

    fun deleteBeverage(beverage: Beverage){
        executorService.execute{ mfoodAppDao.deleteBeverage(beverage) }
    }
}