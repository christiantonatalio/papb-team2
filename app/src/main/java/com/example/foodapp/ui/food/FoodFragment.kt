package com.example.foodapp.ui.food

import android.os.Bundle
import android.util.Log
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
import com.example.foodapp.databinding.FragmentFoodBinding
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Food
import com.example.foodapp.ui.favorite.FavoriteViewModel


class FoodFragment : Fragment() {
    private val foodViewModel: FoodViewModel by viewModels()
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        showListFood()
    }

    private fun showListFood() {
        foodViewModel.getFood()
        val food = foodViewModel.listFood as List<Food>
        favoriteViewModel.getFood().observe(viewLifecycleOwner, { favFoods ->
            showRecycleView(food, favFoods)
        })
    }

    private fun showRecycleView(food: List<Food>, favFood: List<Food>) {
        val foodAdapter = FoodAdapter(food, favFood, activity as AppCompatActivity)
        binding.rvFood.layoutManager = LinearLayoutManager(activity)
        binding.rvFood.adapter = foodAdapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}