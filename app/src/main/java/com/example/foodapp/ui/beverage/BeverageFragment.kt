package com.example.foodapp.ui.beverage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.foodapp.databinding.FragmentBeverageBinding
import com.example.foodapp.model.Beverage

class BeverageFragment : Fragment() {

    private val beverageViewModel: BeverageViewModel by viewModels()
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

        showListBeverages()
    }

    private fun showListBeverages() {
        beverageViewModel.getBeverages()
        val beverages = beverageViewModel.listBeverages

//        showRecyclerView(beverages)
    }

//    private fun showRecyclerView(beverages: ArrayList<Beverage>) {
//        val
//    }
}