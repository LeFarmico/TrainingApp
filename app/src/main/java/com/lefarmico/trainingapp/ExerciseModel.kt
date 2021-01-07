
package com.lefarmico.trainingapp

import com.lefarmico.trainingapp.fragments.IExerciseFragmentTypes

class ExerciseModel {

    private val fragmentList: MutableList<IExerciseFragmentTypes> = mutableListOf()

    fun addFragment(fragment: IExerciseFragmentTypes) {
        fragmentList.add(fragment)
    }

    fun removeFragment(position: Int) {
        fragmentList.removeAt(position)
    }

    fun getFragmentList(): List<IExerciseFragmentTypes> = fragmentList

    fun getFragment(position: Int): IExerciseFragmentTypes = fragmentList[position]
}
