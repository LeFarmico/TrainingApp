package com.lefarmico.trainingapp

import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lefarmico.trainingapp.fragments.FragmentFactory
import com.lefarmico.trainingapp.fragments.FragmentTypes

class ViewPagerFragmentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragmentList: MutableList<FragmentTypes> = mutableListOf()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return FragmentFactory().getFragment(fragmentList[position]) as Fragment
    }

    fun add(fragmentType: FragmentTypes, fragmentCount: Int){
        for (i in 0 .. fragmentCount){
            fragmentList.add(fragmentType)
        }
    }
}
