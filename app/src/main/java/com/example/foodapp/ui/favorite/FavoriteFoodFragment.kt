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
import com.example.foodapp.databinding.FragmentFoodBinding
import com.example.foodapp.model.Food
import com.example.foodapp.ui.food.FoodAdapter
import com.example.foodapp.ui.food.FoodViewModel

class FavoriteFoodFragment : Fragment() {

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

        showListFood()
    }

    private fun showListFood() {
        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        favoriteViewModel.getFood().observe(viewLifecycleOwner, { favFoods ->
            showRecycleView(favFoods)
        })
    }

    private fun showRecycleView(favFood: List<Food>) {
        val foodAdapter = FoodAdapter(favFood, favFood, activity as AppCompatActivity)
        binding.rvFood.layoutManager = LinearLayoutManager(activity)
        binding.rvFood.adapter = foodAdapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}