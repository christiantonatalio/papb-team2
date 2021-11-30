package com.example.foodapp.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.ViewModelFactory
import com.example.foodapp.databinding.FragmentRestaurantBinding
import com.example.foodapp.model.Restaurant
import com.example.foodapp.ui.restaurant.RestaurantAdapter
import com.example.foodapp.ui.restaurant.RestaurantViewModel

class FavoriteRestaurantFragment : Fragment() {

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

        showListRestaurant()
    }

    private fun showListRestaurant() {
        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        favoriteViewModel.getRestaurant().observe(viewLifecycleOwner, { favRestaurant ->
            showRecyclerView(favRestaurant)
        })
    }

    private fun showRecyclerView(favRestaurant: List<Restaurant>) {
        val restaurantAdapter =
            RestaurantAdapter(favRestaurant, favRestaurant, activity as AppCompatActivity)
        binding.rvRestaurant.layoutManager = LinearLayoutManager(activity)
        binding.rvRestaurant.adapter = restaurantAdapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}