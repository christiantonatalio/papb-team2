package com.example.foodapp.ui.restaurant

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
import com.example.foodapp.databinding.ItemRestaurantBinding
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Restaurant
import com.example.foodapp.ui.favorite.FavoriteViewModel

class RestaurantAdapter (private val listRestaurant: List<Restaurant>, private val listFavRestaurant: List<Restaurant>, activity: AppCompatActivity) : RecyclerView.Adapter<RestaurantAdapter.ListViewHolder>() {
    private var mActivity = activity

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemRestaurantBinding.bind(itemView)
        val favoriteViewModel = obtainViewModel(mActivity)
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
        val restaurant = listRestaurant[position]
        var isFav = setFav(restaurant) ?: false
        if(isFav){
            holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
        }

        Glide.with(holder.itemView.context)
            .load(restaurant.image)
            .apply(RequestOptions().override(100, 100))
            .into(holder.binding.imgGambar)

        holder.binding.txtName.text = restaurant.name
        holder.binding.txtPrice.text = restaurant.priceRange
        holder.binding.txtAddress.text = restaurant.address
        holder.binding.btnFav.setOnClickListener {
            Log.d("isClicked", isFav.toString())
            if(isFav){
                holder.favoriteViewModel.deleteRestaurant(restaurant)
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_false)
            } else{
                holder.favoriteViewModel.insertRestaurant(restaurant)
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
            }
            isFav = !isFav
        }
    }

    private fun setFav(restaurant: Restaurant): Boolean? {
        var found = false
        for (n in listFavRestaurant) {
            if (n == restaurant) {
                found = true
                break
            }
        }
        return found
    }
    override fun getItemCount(): Int {
        return listRestaurant.size
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}