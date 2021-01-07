
package com.lefarmico.trainingapp

import android.util.Log
import com.lefarmico.trainingapp.adapters.ExerciseFragmentStateAdapter
import com.lefarmico.trainingapp.fragments.IExerciseFragmentTypes

class ExercisePresenter {

    lateinit var fragmentAdapter: ExerciseFragmentStateAdapter
    private val model: ExerciseModel = ExerciseModel() // Dagger? DI

    fun setFragments(fragments: List<IExerciseFragmentTypes>) {
        for (i in fragments.indices) {
            addFragment(fragments[i])
        }
    }

    fun addFragment(fragment: IExerciseFragmentTypes) {
        val startPos = model.getFragmentList().size + 1
        model.addFragment(fragment)
        fragmentAdapter.notifyItemRangeInserted(startPos, model.getFragmentList().size)
        Log.d("ViewPager", "Fragment created at position: ${model.getFragmentList().size}")
    }

    fun removeFragment(position: Int) {
        val startPos = model.getFragmentList().size + 1
        model.removeFragment(position)
        fragmentAdapter.notifyItemRangeRemoved(model.getFragmentList().size + 1, model.getFragmentList().size)
        Log.d("ViewPager", "Fragment deleted from position: ${model.getFragmentList().size}")
    }

    fun getFragment(position: Int): IExerciseFragmentTypes = model.getFragment(position)

    fun getAllFragments(): List<IExerciseFragmentTypes> = model.getFragmentList()

    fun getItemData(position: Int): String {
        return model.getFragment(position).getFragmentData().toString()
    }

//    fun getViewPagerData(): Exercise{
//        model.getFragmentList().forEach {
//            it.getFragmentData()
//        }
//    }
}
