package com.example.androidassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidassignment.R
import com.example.androidassignment.databinding.ImageContainerBinding
import com.example.androidassignment.model.Image
import com.example.androidassignment.model.ImageItem

class ImageAdapter(val onImageClick:(ImageItem)->Unit):ListAdapter<ImageItem, ImageAdapter.MyViewHolder>(ImageDiffUtils) {

    inner class MyViewHolder(val binding: ImageContainerBinding):RecyclerView.ViewHolder(binding.root)

    object ImageDiffUtils:DiffUtil.ItemCallback<ImageItem>() {
        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ImageItem,
            newItem: ImageItem
        ): Boolean {
            return oldItem==newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ImageContainerBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageItem=getItem(position)

        holder.binding.apply {
            ivImageList.load(imageItem.download_url)
            {
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder)
            }
            root.setOnClickListener {
                onImageClick.invoke(imageItem)
            }
        }
    }
}