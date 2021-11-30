package com.example.foodapp.ui.alarm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityAlarmBinding

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.foodapp.R
//import com.example.foodapp.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        supportFragmentManager.beginTransaction().add(R.id.alarm_holder)
        supportFragmentManager.beginTransaction().add(R.id.alarm_holder, AlarmFragment()).commit()
    }
}