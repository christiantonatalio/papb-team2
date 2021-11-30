package com.example.foodapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Food

@Database(entities = [Beverage::class], version = 2, exportSchema = false)
abstract class FoodAppDatabase : RoomDatabase() {
    abstract val foodAppDao: FoodAppDao

    companion object {

        @Volatile
        private var INSTANCE: FoodAppDatabase? = null

        fun getInstance(context: Context): FoodAppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FoodAppDatabase::class.java,
                        "food_app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}