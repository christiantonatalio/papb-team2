package com.example.foodapp.ui.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.ViewModelFactory
import com.example.foodapp.databinding.FragmentRestaurantBinding
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Restaurant
import com.example.foodapp.ui.beverage.BeverageAdapter
import com.example.foodapp.ui.favorite.FavoriteViewModel

class RestaurantFragment : Fragment() {

    private val restaurantViewModel: RestaurantViewModel by viewModels()
    private lateinit var favoriteViewModel: FavoriteViewModel
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

        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        showListRestaurant()
    }

    private fun showListRestaurant() {
        restaurantViewModel.getRestaurant()
        val restaurant = restaurantViewModel.listRestaurant as List<Restaurant>
        favoriteViewModel.getRestaurant().observe(viewLifecycleOwner, { favRestaurant ->
            showRecyclerView(restaurant, favRestaurant)
        })
    }

    private fun showRecyclerView(restaurant:List<Restaurant>, favRestaurant: List<Restaurant>) {
            val restaurantAdapter =RestaurantAdapter(restaurant, favRestaurant, activity as AppCompatActivity)
            binding.rvRestaurant.layoutManager = LinearLayoutManager(activity)
            binding.rvRestaurant.adapter = restaurantAdapter
        }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
            val factory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
        }
}