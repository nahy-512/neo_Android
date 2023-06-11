package com.neo.myapplication.presentation.ui.main.friends.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neo.myapplication.R
import com.neo.myapplication.databinding.ItemFgFriendsRvListBinding
import com.neo.myapplication.presentation.ui.main.friends.view.FriendsFragment

class FriendAdapter(private val onClick : (Int) -> Unit, private val nicknameList: ArrayList<String>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    interface MyItemClickListener {
        fun onItemClick(nickname: String, image: Int)
    }
    private val plantList = listOf(
        R.drawable.ic_plant1_s, R.drawable.ic_plant1_m, R.drawable.ic_plan1_l,
        R.drawable.ic_plant2_s, R.drawable.ic_plant2_m, R.drawable.ic_plant2_l,
        R.drawable.ic_plant3_s, R.drawable.ic_plant3_m, R.drawable.ic_plant3_l
    )
    private var matchImage = MutableList<Int>(nicknameList.size) { 0 }

    private var rand = -1

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    inner class FriendViewHolder(private val binding: ItemFgFriendsRvListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val containerView = binding.itemFgFriendsRvListCl
        private val defaultTextView = binding.itemFgFriendsRvListTvContent

        fun bind(item : String, position: Int) {
            binding.root.setOnClickListener { onClick.invoke(position) }

            // 화분 주인 더비
            binding.itemFgFriendsRvListTvName.setText(item)

            // 화분 랜덤 할당
            val range = (plantList.indices)
            rand = range.random()

            binding.itemFgFriendsRvListIvImages.setImageResource(plantList[rand])
            matchImage[position] = plantList[rand]

            // 아이템 배경색
            if (position == 1) { // 나이아카의 화분
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
                            2 -> "#FF6058" // main_red
                            4 -> "#06ECA6" // main_green
                            5 -> "#138ADC" // main_blue
                            else -> {
                                "#FFEC08" // main_yellow
                            }
                        }
                    } else -> {
                        color = "#FFFFFF"
                    }
                }
                binding.itemFgFriendsRvListCv.setCardBackgroundColor(Color.parseColor(color))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(ItemFgFriendsRvListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = nicknameList.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(nicknameList[position], position)
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(nicknameList[position], matchImage[position])
        }
    }
}