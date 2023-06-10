package com.neo.myapplication.presentation.ui.main.friends.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.databinding.ItemFgFriendsRvListBinding

class FriendAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    //TODO: 데이터 목록 넣기
    inner class FriendViewHolder(private val binding: ItemFgFriendsRvListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener { onClick.invoke(0) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(ItemFgFriendsRvListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 10 //TODO: 임의로 10

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind()
    }
}