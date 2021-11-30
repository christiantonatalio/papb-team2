package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class Food (
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var foodId: Int? = 0,

    @ColumnInfo(name = "food_column_name")
    var name: String? = "",

    @ColumnInfo(name = "food_column_description")
    var description: String? = "",

    @ColumnInfo(name = "food_column_image")
    var image: Int? = 0
)