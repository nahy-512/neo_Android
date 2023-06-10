package com.neo.myapplication.presentation.ui.location.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.data.remote.response.ResponseLocationData
import com.neo.myapplication.databinding.ItemSearchLocationResultFormBinding

class SearchLocationAdapter(private val onClick : (String) -> Unit) : RecyclerView.Adapter<SearchLocationAdapter.SearchLocationViewHolder>() {
    var locationList = mutableListOf<ResponseLocationData.LocationData>()
    inner class SearchLocationViewHolder(private val binding : ItemSearchLocationResultFormBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ResponseLocationData.LocationData) {
            binding.locationData = item
            binding.root.setOnClickListener { onClick.invoke(item.place_name) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchLocationViewHolder {
        return SearchLocationViewHolder(ItemSearchLocationResultFormBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = locationList.size

    override fun onBindViewHolder(holder: SearchLocationViewHolder, position: Int) {
        holder.bind(locationList[position])
    }
}