package com.lefarmico.trainingapp.utilites

import androidx.recyclerview.widget.DiffUtil
import com.lefarmico.trainingapp.dataClasses.SetTypesData

class ParamSetsDiffUtils(
    private val oldList: List<SetTypesData>,
    private val newList: List<SetTypesData>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
