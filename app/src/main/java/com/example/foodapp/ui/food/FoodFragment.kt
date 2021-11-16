package com.example.foodapp.ui.food

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
import com.example.foodapp.databinding.FragmentFoodBinding
import com.example.foodapp.model.Food


class FoodFragment : Fragment() {

    private val foodViewModel: FoodViewModel by viewModels()
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
        foodViewModel.getFood()
        val food = foodViewModel.listFood

        showRecycleView(food)
    }

    private fun showRecycleView(food: ArrayList<Food>) {
        val foodAdapter = FoodAdapter(food)
        binding.rvFood.layoutManager = LinearLayoutManager(activity)
        binding.rvFood.adapter = foodAdapter
    }
}