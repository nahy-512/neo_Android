package com.neo.myapplication.presentation.ui.main.friends.adapter

import android.graphics.Color
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
                params?.height = params?.width
                containerView.layoutParams = params

                val color: String

                when(position % 4) {
                    0,1 -> { // 색이 있는
                        color = when (position % 6) {
                            1 -> "#FF6058" // main_red
                            4 -> "#138ADC" // main_blue
                            5 -> "#06ECA6" // main_green
                            else -> {
                                "#FFEC08" // main_yellow
                            }
                        }
                    } else -> {
                        color = "#FFFFFF"
                        //binding.itemFgFriendsRvListIvImages.visibility = View.GONE
                    }
                }
                binding.itemFgFriendsRvListCv.setCardBackgroundColor(Color.parseColor(color))
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