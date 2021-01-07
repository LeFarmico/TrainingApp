
package com.lefarmico.trainingapp.fragments

import com.lefarmico.trainingapp.dataClasses.ParamOfSet

interface IExerciseFragmentTypes {
    fun getFragmentData(): List<ParamOfSet>
    fun setFragmentTitle(title: String)
}
