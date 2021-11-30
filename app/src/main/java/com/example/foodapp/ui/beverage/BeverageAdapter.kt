package com.example.foodapp.ui.beverage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.ui.favorite.FavoriteViewModel
import com.example.foodapp.R
import com.example.foodapp.ViewModelFactory
import com.example.foodapp.databinding.ItemBeverageBinding
import com.example.foodapp.model.Beverage

class BeverageAdapter(private val listBeverage: List<Beverage>, private val listFavBeverage: List<Beverage>, activity: AppCompatActivity) : RecyclerView.Adapter<BeverageAdapter.ListViewHolder>() {
    private var mActivity = activity

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemBeverageBinding.bind(itemView)
        val favoriteViewModel = obtainViewModel(mActivity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_beverage,
            parent,
            false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val beverage = listBeverage[position]
        var isFav = setFav(beverage) ?: false
        if(isFav){
            holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
        }

        Log.d("isFav", isFav.toString())

        Glide.with(holder.itemView.context)
            .load(beverage.image)
            .apply(RequestOptions().override(100, 100))
            .into(holder.binding.imgGambar)

        holder.binding.txtName.text = beverage.name
        holder.binding.txtDescrption.text = beverage.description
        holder.binding.btnFav.setOnClickListener {
            Log.d("isClicked", isFav.toString())
            if(isFav){
                holder.favoriteViewModel.deleteBeverage(beverage)
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_false)
            } else{
                holder.favoriteViewModel.insertBeverage(beverage)
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
            }
            isFav = !isFav
        }
    }

    private fun setFav(beverage: Beverage): Boolean? {
        var found = false
        for (n in listFavBeverage) {
            if (n == beverage) {
                found = true
                break
            }
        }
        return found
    }

    override fun getItemCount(): Int {
        return listBeverage.size
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}