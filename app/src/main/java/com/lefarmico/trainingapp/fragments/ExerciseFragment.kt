
package com.lefarmico.trainingapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lefarmico.trainingapp.adapters.RepsTypeAdapter
import com.lefarmico.trainingapp.dataClasses.ExerciseData
import com.lefarmico.trainingapp.dataClasses.RepsType
import com.lefarmico.trainingapp.dataClasses.SetTypesData
import com.lefarmico.trainingapp.databinding.FragmentExerciseBinding
import com.lefarmico.trainingapp.utilites.OnSwipeListener

class ExerciseFragment(
    override val exerciseData: ExerciseData
) : Fragment(), IExerciseFragmentTypes {

    lateinit var recyclerView: RecyclerView
    private var _binding: FragmentExerciseBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentTitle(exerciseData.title)
        recyclerView = binding.exSetsPlaceholder
        recyclerView.apply {
            adapter = RepsTypeAdapter()

            val sets = exerciseData.sets

            (adapter as RepsTypeAdapter).addItems(sets)
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.exerciseFragment.setOnTouchListener(object : OnSwipeListener(requireContext()) {

            override fun onSwipeDown() {
                (recyclerView.adapter as RepsTypeAdapter).addItem(RepsType(0, 0))
                Toast.makeText(requireContext(), "Swipe down", Toast.LENGTH_SHORT).show()
            }

            override fun onSwipeTop() {
                (recyclerView.adapter as RepsTypeAdapter)
                    .removeItem((recyclerView.adapter as RepsTypeAdapter).itemCount - 1)
                Toast.makeText(requireContext(), "Swipe top", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getFragmentData(): List<SetTypesData> {
        return (recyclerView.adapter as RepsTypeAdapter).getItems()
    }

    override fun setFragmentTitle(title: String) {
        binding.exName.text = title
    }
}
