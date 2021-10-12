package com.example.foodapp.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private val aboutViewModel: AboutViewModel by viewModels()
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }
}