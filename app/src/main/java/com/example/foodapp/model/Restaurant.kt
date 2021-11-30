package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class Restaurant (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var restaurantId: Int = 0,

    @ColumnInfo(name = "restaurant_column_name")
    var name: String? = "",

    @ColumnInfo(name = "restaurant_column_address")
    var address: String? = "",

    @ColumnInfo(name = "restaurant_column_priceRange")
    var priceRange: String? = "",

    @ColumnInfo(name = "restaurant_column_image")
    var image: Int? = 0
)