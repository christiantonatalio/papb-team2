package com.example.foodapp.room

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.foodapp.model.Beverage

interface FoodAppDao {
@Insert
fun insertBeverage(beverage: Beverage)

@Query ("DELETE FROM beverage_table")
fun deleteBeverage()

@Query ("SELECT * FROM beverage_table")
fun getBeverage()
}