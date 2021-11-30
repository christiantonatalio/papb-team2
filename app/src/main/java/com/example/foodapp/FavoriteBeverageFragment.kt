package com.example.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentBeverageBinding
import com.example.foodapp.databinding.FragmentFavoritBeverageBinding
import com.example.foodapp.model.Beverage
import com.example.foodapp.ui.beverage.BeverageAdapter
import com.example.foodapp.ui.beverage.BeverageViewModel


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

        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        showListBeverages()
    }

    private fun showListBeverages() {
        favoriteViewModel.getBeverage().observe(viewLifecycleOwner, {beverages ->
            showRecyclerView(beverages)
        })
    }

    private fun showRecyclerView(beverages: ArrayList<Beverage>) {
        val beverageAdapter = BeverageAdapter(beverages)
        binding.rvBeverages.layoutManager = LinearLayoutManager(activity)
        binding.rvBeverages.adapter = beverageAdapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}