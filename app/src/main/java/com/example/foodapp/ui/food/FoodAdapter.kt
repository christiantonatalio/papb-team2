package com.example.foodapp.ui.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemFoodBinding
import com.example.foodapp.model.Food

class FoodAdapter (private val listBeverage: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemFoodBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_food,
            parent,
            false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val beverage = listBeverage[position]

        Glide.with(holder.itemView.context)
            .load(beverage.image)
            .apply(RequestOptions().override(100, 100))
            .into(holder.binding.imgGambar)

        holder.binding.txtName.text = beverage.name
        holder.binding.txtDescrption.text = beverage.description
    }

    override fun getItemCount(): Int {
        return listBeverage.size
    }
}