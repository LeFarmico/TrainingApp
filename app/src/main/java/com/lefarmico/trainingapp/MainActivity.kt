
package com.lefarmico.trainingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.lefarmico.trainingapp.adapters.ExerciseFragmentStateAdapter
import com.lefarmico.trainingapp.dataClasses.ExerciseData
import com.lefarmico.trainingapp.dataClasses.RepsType
import com.lefarmico.trainingapp.databinding.ActivityMainBinding
import com.lefarmico.trainingapp.fragments.ExerciseFragment

class MainActivity : AppCompatActivity() {

//    private val pagerAdapter: ViewPagerFragmentStateAdapter by lazy { ViewPagerFragmentStateAdapter(this) }
    private lateinit var binding: ActivityMainBinding
    var exerciseData = ExerciseData()
    private val presenter = ExercisePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.apply {
            fragmentAdapter = ExerciseFragmentStateAdapter(this@MainActivity)
            fragmentAdapter.presenter = this
        }

        exerciseData = ExerciseData(
            "Potumba",
            listOf(
                RepsType(),
                RepsType()
            )
        )
        init()
        createNewExercise()
    }
    private fun init() {
        binding.exFabButton.setOnClickListener {
            val curFragment = binding.pager.currentItem
            Toast.makeText(
                this,
                presenter.getItemData(curFragment),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // Лаг анимации
                if (position == presenter.getAllFragments().size - 1) {
                    presenter.addFragment(ExerciseFragment(exerciseData))
                }
            }
        })
    }
    private fun createNewExercise() {
        presenter.setFragments(
            listOf(
                ExerciseFragment(exerciseData),
                ExerciseFragment(exerciseData)
            )
        )
        binding.pager.offscreenPageLimit = 3
        binding.pager.adapter = presenter.fragmentAdapter
    }
}
