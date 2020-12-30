package com.lefarmico.trainingapp.fragments

import com.lefarmico.trainingapp.dataClasses.Exercise
import java.lang.NullPointerException

class FragmentFactory {

    fun getFragment(type: FragmentTypes): IFragmentTypes?{
        try {
            if (type == FragmentTypes.EXERCISE)
                return ExerciseFragment()
        }catch (e: NullPointerException){
            e.stackTrace
        }
        return null
    }
}
enum class FragmentTypes {
    EXERCISE //
}