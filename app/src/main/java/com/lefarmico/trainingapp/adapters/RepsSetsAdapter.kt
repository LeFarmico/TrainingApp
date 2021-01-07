
package com.lefarmico.trainingapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lefarmico.trainingapp.dataClasses.RepsSets
import com.lefarmico.trainingapp.databinding.RepsLayoutBinding
import com.lefarmico.trainingapp.utilites.ParamSetsDiffUtils

class RepsOfSetsAdapter : RecyclerView.Adapter<RepsSetsViewHolder>() {

    private val items = mutableListOf<RepsSets>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepsSetsViewHolder =
        RepsSetsViewHolder(RepsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RepsSetsViewHolder, position: Int) {
        Log.d("TAG", "bind, position = $position")
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItems(list: List<RepsSets>) {
        items.addAll(list)
    }
    fun getItems(): List<RepsSets> = items

    fun addItem(item: RepsSets) {
        items.add(item)
        notifyItemChanged(items.size - 1)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(items.size)
    }

    fun updateItems(newItemsList: List<RepsSets>) {
        val oldSize = items.size
        val diffResult = DiffUtil.calculateDiff(ParamSetsDiffUtils(items, newItemsList))
        diffResult.dispatchUpdatesTo(this)
        notifyItemRangeInserted(oldSize, items.size)
    }
}

class RepsSetsViewHolder(repsLayoutBinding: RepsLayoutBinding) : RecyclerView.ViewHolder(repsLayoutBinding.root) {
    private val reps = repsLayoutBinding.repsCount
    private val weight = repsLayoutBinding.weights

    fun bind(repsOfSets: RepsSets) {
        reps.text = repsOfSets.reps.toString()
        weight.text = repsOfSets.weight.toString()
    }
}
