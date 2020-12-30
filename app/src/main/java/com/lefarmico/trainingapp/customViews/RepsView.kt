package com.lefarmico.trainingapp.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lefarmico.trainingapp.R
import kotlinx.android.synthetic.main.reps_layout.view.*
import org.jetbrains.annotations.Nullable

class RepsView(context: Context, @Nullable attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {

    private val repsCountEditText: TextView
    private val weightsEditText : TextView
    private val setNumberText: TextView
    private val deleteFab: FloatingActionButton

    init {
        LayoutInflater.from(context).inflate(R.layout.reps_layout, this, true)

        this.orientation = HORIZONTAL

        repsCountEditText = reps_count
        setNumberText = reps_of_set
        weightsEditText = weights
        deleteFab = delete_set_button
    }
}