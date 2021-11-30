package com.example.foodapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Food

@Dao
interface FoodAppDao {

@Insert
fun insertBeverage(beverage: Beverage)

@Insert
fun insertFood(food: Food)

@Delete
fun deleteBeverage(beverage: Beverage)

@Delete
fun deleteFood(food: Food)

@Query ("SELECT * FROM beverage_table")
fun getBeverage() : LiveData<List<Beverage>>

@Query ("SELECT * FROM beverage_table")
fun getFood() : LiveData<List<Food>>
}