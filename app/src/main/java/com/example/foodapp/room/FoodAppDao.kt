package com.example.foodapp.room

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Food
import com.example.foodapp.model.Restaurant

interface FoodAppDao {
@Insert
fun insertBeverage(beverage: Beverage)

@Insert
fun insertFood(food: Food)

@Insert
fun insertRestaurant(restaurant: Restaurant)

@Query ("DELETE FROM beverage_table")
fun deleteBeverage()

@Query("DELETE FROM food_table")
fun deleteFood()

@Query("DELETE FROM restaurant_table")
fun deleteRestaurant()

@Query ("SELECT * FROM beverage_table")
fun getBeverage()

@Query ("SELECT * FROM food_table")
fun getFood()

@Query("SELECT * FROM restaurant_table")
fun getRestaurant()
}