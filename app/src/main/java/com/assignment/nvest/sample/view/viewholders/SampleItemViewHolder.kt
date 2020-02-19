package com.assignment.nvest.sample.view.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.assignment.nvest.databinding.ItemSampleBinding
import com.assignment.nvest.sample.model.SampleData

class SampleItemViewHolder(private var binding: ItemSampleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(sampleData: SampleData) {
        binding.data = sampleData
    }
}
