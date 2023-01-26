package com.llc.mybinarylab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.llc.mybinarylab.databinding.CategoryItemBinding
import com.llc.mybinarylab.databinding.PopularItemBinding

class CategoryItemAdapter : ListAdapter<CategoryModel, CategoryItemAdapter.CategoryViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item: CategoryModel = getItem(position)
        holder.bind(item)
    }

    class CategoryViewHolder(
        private var binding: CategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryModel: CategoryModel) {

            with(binding) {
                tvCategory.text = categoryModel.categoryName
                ivCategory.setImageResource(categoryModel.categoryImg)
                rlCategory.setBackgroundResource(categoryModel.bgColor)
            }
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<CategoryModel>() {

        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.categoryName == newItem.categoryName
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }
    }
}