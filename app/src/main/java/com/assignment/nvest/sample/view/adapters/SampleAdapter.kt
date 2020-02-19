package com.assignment.nvest.sample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assignment.nvest.R
import com.assignment.nvest.databinding.ItemSampleBinding
import com.assignment.nvest.sample.model.SampleData
import com.assignment.nvest.sample.view.viewholders.SampleItemViewHolder


class SampleAdapter constructor(private val data: List<SampleData>) : RecyclerView.Adapter<SampleItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleItemViewHolder {
        var itemFeedBinding: ItemSampleBinding? = null
        itemFeedBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_sample,
            parent,
            false
        )
        return SampleItemViewHolder(itemFeedBinding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SampleItemViewHolder, position: Int) {
        holder.bindData(data[position])
    }

}