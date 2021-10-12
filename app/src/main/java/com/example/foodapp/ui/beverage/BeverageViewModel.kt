package com.example.foodapp.ui.beverage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeverageViewModel : ViewModel()
{
    private val _text = MutableLiveData<String>().apply {
        value = "This is Bevarage Fragment"
    }
    val text: LiveData<String> = _text
}