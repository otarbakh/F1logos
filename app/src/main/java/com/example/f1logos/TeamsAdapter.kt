package com.example.f1logos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.f1logos.databinding.SingleteamlayoutBinding

class TeamsAdapter : ListAdapter<TeamData, TeamsAdapter.TeamViewHolder>(DiffCallBack()) {

    private lateinit var onItemCLickListener: (TeamData, Int) -> Unit

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamViewHolder {
        val binding =
            SingleteamlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind()
    }

    inner class TeamViewHolder(private val binding: SingleteamlayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val data = getItem(adapterPosition)
            binding.tvTeamLogo.setOnClickListener {
                onItemCLickListener.invoke(data, adapterPosition)
            }

            binding.tvTeamLogo.setImageResource(data.image)

        }
    }
    class DiffCallBack:DiffUtil.ItemCallback<TeamData>(){
        override fun areItemsTheSame(oldItem: TeamData, newItem: TeamData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: TeamData, newItem: TeamData): Boolean {
            return oldItem == newItem
        }

    }

    fun setOnDeleteClickListener(clickListener: (TeamData, Int) -> Unit) {
        this.onItemCLickListener = clickListener
    }


}