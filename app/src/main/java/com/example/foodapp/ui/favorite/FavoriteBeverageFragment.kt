package com.example.foodapp.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.ViewModelFactory
import com.example.foodapp.databinding.FragmentFavoritBeverageBinding
import com.example.foodapp.model.Beverage
import com.example.foodapp.ui.beverage.BeverageAdapter


class FavoritBeverage : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var binding: FragmentFavoritBeverageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoritBeverageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListBeverages()
    }

    private fun showListBeverages() {
        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        favoriteViewModel.getBeverages().observe(viewLifecycleOwner, { beverages ->
            showRecyclerView(beverages)
        })
    }

    private fun showRecyclerView(beverages: List<Beverage>) {
        val beverageAdapter = BeverageAdapter(beverages, beverages, activity as AppCompatActivity)
        binding.rvBeverages.layoutManager = LinearLayoutManager(activity)
        binding.rvBeverages.adapter = beverageAdapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}