package com.lefarmico.trainingapp.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lefarmico.trainingapp.ExercisePresenter

class ExerciseFragmentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    lateinit var presenter: ExercisePresenter // Dagger? DI

    override fun getItemCount(): Int = presenter.getAllFragments().size

    override fun createFragment(position: Int): Fragment {
        Log.d("ViewPager", "Fragment created at position: $position")
        return presenter.getFragment(position) as Fragment
    }
}
