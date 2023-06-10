package com.neo.myapplication.presentation.ui.main.friends.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.databinding.ItemFgFriendsRvListBinding

class FriendAdapter(private val onClick : (Int) -> Unit, private val imageList: ArrayList<Int>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    inner class FriendViewHolder(private val binding: ItemFgFriendsRvListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val containerView = binding.itemFgFriendsRvListCl
        private val defaultTextView = binding.itemFgFriendsRvListTvContent
        fun bind(item : Int, position: Int) {
            binding.root.setOnClickListener { onClick.invoke(position) }
            if (position == 1) { // 나이아키의 화분
                containerView.visibility = View.GONE
                defaultTextView.visibility = View.VISIBLE
            } else {
                containerView.visibility = View.VISIBLE
                defaultTextView.visibility = View.GONE

                val params: ViewGroup.LayoutParams? = containerView.layoutParams
                //params?.width = width
                params?.height = params?.width

                containerView.layoutParams = params
                //imageView.layoutParams?.height = imageView.layoutParams?.width
                //binding.itemFgFriendsRvListIvImages.maxHeight = binding.itemFgFriendsRvListIvImages.width
            }
            binding.itemFgFriendsRvListIvImages.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(ItemFgFriendsRvListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(imageList[position], position)
    }
}