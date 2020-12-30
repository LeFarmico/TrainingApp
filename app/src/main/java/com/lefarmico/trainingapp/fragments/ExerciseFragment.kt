package com.lefarmico.trainingapp.fragments

import android.animation.AnimatorInflater
import android.animation.LayoutTransition
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.size
import com.lefarmico.trainingapp.R
import com.lefarmico.trainingapp.customViews.RepsView
import com.lefarmico.trainingapp.dataClasses.Exercise
import com.lefarmico.trainingapp.dataClasses.WorkoutSet
import com.lefarmico.trainingapp.utilites.OnSwipeListener
import kotlinx.android.synthetic.main.fragment_exercise.*
import kotlinx.android.synthetic.main.reps_layout.view.*

class ExerciseFragment : Fragment(), IFragmentTypes {

    private val exercise = Exercise("Pull Ups", 5)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ex_fab_button.setOnClickListener {
//            val exercise = getExercise()
//            Toast.makeText(requireContext(),
//            "Exercise name ${exercise.exerciseName}, sets count: ${exercise.defSetsCount}", Toast.LENGTH_SHORT).show()
//        }

        ex_name.text = exercise.exerciseName
        for (i in 0..exercise.defSetsCount) {
            createViewLayout(R.layout.reps_layout, ex_sets_placeholder)
        }
        ex_sets_placeholder
                .layoutTransition
                .setAnimator(LayoutTransition.APPEARING,
                        AnimatorInflater.loadAnimator(requireContext(),
                                R.animator.create_animator))

        exercise_fragment.setOnTouchListener(object : OnSwipeListener(requireContext()) {
            override fun onSwipeDown() {
                Toast.makeText(requireContext(), "Swipe Down", Toast.LENGTH_SHORT).show()
                createViewLayout(R.layout.reps_layout, ex_sets_placeholder)
            }

            override fun onSwipeTop() {
                Toast.makeText(requireContext(), "Swipe Up", Toast.LENGTH_SHORT).show()
                ex_sets_placeholder.removeViewAt(ex_sets_placeholder.childCount - 1)
            }
        })

    }

    private fun createViewLayout(layoutId: Int, viewGroup: ViewGroup) {
        layoutInflater.inflate(layoutId, viewGroup)
        if (viewGroup[viewGroup.childCount - 1] is LinearLayout) {
            (viewGroup[viewGroup.childCount - 1] as LinearLayout)[0].setOnClickListener {
                (it.parent.parent as LinearLayout).removeViewAt(viewGroup.indexOfChild((it.parent as LinearLayout)))
                Toast.makeText(requireContext(),
                        "Delete set at index ${viewGroup.indexOfChild((it.parent as LinearLayout))}",
                        Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }

    fun getNumberOfFragment() : Int? = fragmentManager?.fragments?.indexOf(this)
    fun getExercise(): Exercise {
        val setsCount = ex_sets_placeholder.size
        var setsList = mutableListOf<WorkoutSet>()
        for (i in 0 until setsCount) {
            val reps: Int = ex_sets_placeholder[i].reps_count.text.toString().toInt()
            val weight: Int = ex_sets_placeholder[i].weights.text.toString().toInt()
            setsList.add(WorkoutSet(reps, weight))
        }
        return Exercise(exercise.exerciseName, setsList.size, setsList)
    }
//        ex_fab_button.setOnClickListener {
//            val bundle = Bundle()
//            val currentFragmentIndex = fragmentManager?.fragments?.indexOf(this)
//            val fragmentsSize = this.fragmentManager?.fragments?.size
//
//
//            for (i in 0..currentFragmentIndex!!){
//                (fragmentManager?.fragments?.get(i) as ExerciseFragment).parseInfo()
//            }
//            Toast.makeText(requireContext(), "$", Toast.LENGTH_SHORT).show()
//        }
//    }
}