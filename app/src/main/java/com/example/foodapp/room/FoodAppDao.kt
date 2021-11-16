package com.example.foodapp.room

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Food

interface FoodAppDao {
@Insert
fun insertBeverage(beverage: Beverage)

@Insert
fun insertFood(food: Food)

@Query ("DELETE FROM beverage_table")
fun deleteBeverage()

@Query("DELETE FROM food_table")
fun deleteFood()

@Query ("SELECT * FROM beverage_table")
fun getBeverage()

@Query ("SELECT * FROM food_table")
fun getFood()
}