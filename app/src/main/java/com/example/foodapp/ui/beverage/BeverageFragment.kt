package com.example.foodapp.ui.beverage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.databinding.FragmentBeverageBinding

class BeverageFragment : Fragment() {

    private lateinit var beverageViewModel: BeverageViewModel
    private var _binding: FragmentBeverageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beverageViewModel =
            ViewModelProvider(this).get(BeverageViewModel::class.java)

        _binding = FragmentBeverageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBeverage
        beverageViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}