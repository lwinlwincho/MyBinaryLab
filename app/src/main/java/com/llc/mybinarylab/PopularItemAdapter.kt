package com.llc.mybinarylab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.llc.mybinarylab.databinding.PopularItemBinding

class PopularItemAdapter : ListAdapter<PopularModel, PopularItemAdapter.PopularViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item: PopularModel = getItem(position)
        holder.bind(item)
    }

    class PopularViewHolder(
        private var binding: PopularItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(popularModel: PopularModel) {

            with(binding) {
                tvPopularSubTitle.text = popularModel.title
                ivPopularCourse.setImageResource(R.drawable.ic_card_heading)

            }
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<PopularModel>() {

        override fun areItemsTheSame(oldItem: PopularModel, newItem: PopularModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PopularModel, newItem: PopularModel): Boolean {
            return oldItem == newItem
        }
    }
}