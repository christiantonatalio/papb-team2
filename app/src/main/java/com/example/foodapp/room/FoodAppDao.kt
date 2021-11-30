package com.example.foodapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodapp.model.Beverage

@Dao
interface FoodAppDao {

@Insert
fun insertBeverage(beverage: Beverage)

@Delete
fun deleteBeverage(beverage: Beverage)

@Query ("SELECT * FROM beverage_table")
fun getBeverage() : LiveData<List<Beverage>>
}