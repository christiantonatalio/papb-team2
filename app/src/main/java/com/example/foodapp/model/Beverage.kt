package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beverage_table")
data class Beverage (
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "beverage_column_name")
    var name: String? = "",

    @ColumnInfo(name = "beverage_column_description")
    var description: String? = "",

    @ColumnInfo(name = "beverage_column_image")
    var image: Int? = 0
)