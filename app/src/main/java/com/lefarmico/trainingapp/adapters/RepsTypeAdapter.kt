
package com.lefarmico.trainingapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lefarmico.trainingapp.dataClasses.RepsType
import com.lefarmico.trainingapp.dataClasses.SetTypesData
import com.lefarmico.trainingapp.databinding.RepsLayoutBinding
import com.lefarmico.trainingapp.utilites.ParamSetsDiffUtils

class RepsTypeAdapter : RecyclerView.Adapter<RepsTypeAdapter.RepsSetsViewHolder>() {
    inner class RepsSetsViewHolder(
        repsLayoutBinding: RepsLayoutBinding
    ) : RecyclerView.ViewHolder(repsLayoutBinding.root) {

        private val reps = repsLayoutBinding.repsCount
        private val weight = repsLayoutBinding.weights

        fun bind(repsOfSets: SetTypesData) {
            when (repsOfSets) {
                is RepsType -> {
                    reps.text = repsOfSets.reps.toString()
                    weight.text = repsOfSets.weight.toString()
                }
            }
        }
    }

    private val items = mutableListOf<SetTypesData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepsSetsViewHolder =
        RepsSetsViewHolder(
            RepsLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RepsSetsViewHolder, position: Int) {
        Log.d("TAG", "bind, position = $position")
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItems(list: List<SetTypesData>) {
        items.addAll(list)
    }
    fun getItems(): List<SetTypesData> = items

    fun addItem(item: RepsType) {
        items.add(item)
        notifyItemChanged(items.size - 1)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(items.size)
    }

    fun updateItems(newItemsList: List<RepsType>) {
        val oldSize = items.size
        val diffResult = DiffUtil.calculateDiff(ParamSetsDiffUtils(items, newItemsList))
        diffResult.dispatchUpdatesTo(this)
        notifyItemRangeInserted(oldSize, items.size)
    }
}
