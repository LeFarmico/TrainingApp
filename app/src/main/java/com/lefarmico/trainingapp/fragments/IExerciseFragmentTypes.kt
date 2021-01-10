
package com.lefarmico.trainingapp.fragments

import com.lefarmico.trainingapp.dataClasses.ExerciseData
import com.lefarmico.trainingapp.dataClasses.SetTypesData

interface IExerciseFragmentTypes {
    val exerciseData: ExerciseData
    fun getFragmentData(): List<SetTypesData>
    fun setFragmentTitle(title: String)
}
