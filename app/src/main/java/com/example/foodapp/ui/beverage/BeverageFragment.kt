package com.example.foodapp.ui.beverage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.ui.favorite.FavoriteViewModel
import com.example.foodapp.ViewModelFactory
import com.example.foodapp.databinding.FragmentBeverageBinding
import com.example.foodapp.model.Beverage

class BeverageFragment : Fragment() {
    private val beverageViewModel: BeverageViewModel by viewModels()
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var binding: FragmentBeverageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBeverageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteViewModel = obtainViewModel(activity as AppCompatActivity)
        showListBeverages()
    }

    private fun showListBeverages() {
        beverageViewModel.getBeverages()
        val beverages = beverageViewModel.listBeverages as List<Beverage>
        favoriteViewModel.getBeverages().observe(viewLifecycleOwner, { favBeverages ->
            showRecyclerView(beverages, favBeverages)
        })
    }

    private fun showRecyclerView(beverages: List<Beverage>, favBeverages: List<Beverage>) {
        val beverageAdapter = BeverageAdapter(beverages, favBeverages, activity as AppCompatActivity)
        binding.rvBeverages.layoutManager = LinearLayoutManager(activity)
        binding.rvBeverages.adapter = beverageAdapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}