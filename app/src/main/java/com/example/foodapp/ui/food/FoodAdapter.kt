package com.example.foodapp.ui.food

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.R
import com.example.foodapp.ViewModelFactory
import com.example.foodapp.databinding.ItemFoodBinding
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Food
import com.example.foodapp.ui.favorite.FavoriteViewModel

class FoodAdapter (private val listFood: List<Food>, private val listFavFood: List<Food>, activity: AppCompatActivity) : RecyclerView.Adapter<FoodAdapter.ListViewHolder>() {
    private var mActivity = activity

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemFoodBinding.bind(itemView)
        val favoriteViewModel = obtainViewModel(mActivity)
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
        val food = listFood[position]
        var isFav = setFav(food) ?: false
        if(isFav){
            holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
        }

        Glide.with(holder.itemView.context)
            .load(food.image)
            .apply(RequestOptions().override(100, 100))
            .into(holder.binding.imgGambar)

        holder.binding.txtName.text = food.name
        holder.binding.txtDescrption.text = food.description
        holder.binding.btnFav.setOnClickListener {
            if(isFav){
                holder.favoriteViewModel.deleteFood(food)
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_false)
            } else{
                holder.favoriteViewModel.insertFood(food)
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
            }
            isFav = !isFav
        }
    }

    private fun setFav(food: Food): Boolean? {
        var found = false
        for (n in listFavFood) {
            if (n == food) {
                found = true
                break
            }
        }
        return found
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}