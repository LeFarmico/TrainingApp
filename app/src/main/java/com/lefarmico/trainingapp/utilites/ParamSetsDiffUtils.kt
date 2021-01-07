package com.lefarmico.trainingapp.utilites

import androidx.recyclerview.widget.DiffUtil
import com.lefarmico.trainingapp.dataClasses.ParamOfSet

class ParamSetsDiffUtils(
    private val oldList: List<ParamOfSet>,
    private val newList: List<ParamOfSet>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
