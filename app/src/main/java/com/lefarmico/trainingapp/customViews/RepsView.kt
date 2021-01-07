
package com.lefarmico.trainingapp.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lefarmico.trainingapp.databinding.RepsLayoutBinding
import org.jetbrains.annotations.Nullable

class RepsView(context: Context, @Nullable attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {

    private val binding: RepsLayoutBinding =
        RepsLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    private val repsCountEditText: TextView
    private val weightsEditText: TextView
    private val setNumberText: TextView
    private val deleteFab: FloatingActionButton

    init {
        this.orientation = HORIZONTAL

        repsCountEditText = binding.repsCount
        setNumberText = binding.repsOfSet
        weightsEditText = binding.weights
        deleteFab = binding.deleteSetButton
    }
}
