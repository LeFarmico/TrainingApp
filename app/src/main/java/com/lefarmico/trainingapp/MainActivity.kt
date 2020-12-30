package com.lefarmico.trainingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lefarmico.trainingapp.fragments.ExerciseFragment
import com.lefarmico.trainingapp.fragments.FragmentTypes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pagerAdapter: ViewPagerFragmentStateAdapter by lazy { ViewPagerFragmentStateAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNewExercise()

        ex_fab_button.setOnClickListener {
            val curFragment = supportFragmentManager.primaryNavigationFragment
            Toast.makeText(this, "current fragment is ${curFragment.toString() }", Toast.LENGTH_SHORT).show()
        }

    }
    private fun createNewExercise(){
        pager.offscreenPageLimit = 3
        pager.adapter = pagerAdapter
        pagerAdapter.add(FragmentTypes.EXERCISE, 30)

    }
}