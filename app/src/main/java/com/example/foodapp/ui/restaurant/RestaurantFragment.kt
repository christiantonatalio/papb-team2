package com.example.foodapp.ui.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentRestaurantBinding
import com.example.foodapp.model.Restaurant

class RestaurantFragment : Fragment() {

    private val restaurantViewModel: RestaurantViewModel by viewModels()
    private lateinit var binding: FragmentRestaurantBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListRestaurant()
    }

    private fun showListRestaurant() {
        restaurantViewModel.getRestaurant()
        val restaurant = restaurantViewModel.listRestaurant
        
        showRecycleView(restaurant)

    }

    private fun showRecycleView(restaurant: ArrayList<Restaurant>) {
        val restaurantAdapter = RestaurantAdapter(restaurant)
        binding.rvRestaurant.layoutManager = LinearLayoutManager(activity)
        binding.rvRestaurant.adapter = restaurantAdapter
    }
}