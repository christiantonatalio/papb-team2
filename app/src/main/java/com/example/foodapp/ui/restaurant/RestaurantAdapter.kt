package com.example.foodapp.ui.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemRestaurantBinding
import com.example.foodapp.model.Restaurant

class RestaurantAdapter (private val listBeverage: ArrayList<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemRestaurantBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_restaurant,
            parent,
            false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val restaurant = listBeverage[position]

        Glide.with(holder.itemView.context)
            .load(restaurant.image)
            .apply(RequestOptions().override(100, 100))
            .into(holder.binding.imgGambar)

        holder.binding.txtName.text = restaurant.name
        holder.binding.txtPrice.text = restaurant.priceRange
        holder.binding.txtAddress.text = restaurant.address
    }

    override fun getItemCount(): Int {
        return listBeverage.size
    }
}