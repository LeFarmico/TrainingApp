
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
import com.lefarmico.trainingapp.adapters.RepsOfSetsAdapter
import com.lefarmico.trainingapp.dataClasses.ParamOfSet
import com.lefarmico.trainingapp.dataClasses.RepsSets
import com.lefarmico.trainingapp.databinding.FragmentExerciseBinding
import com.lefarmico.trainingapp.utilites.OnSwipeListener

class ExerciseFragment : Fragment(), IExerciseFragmentTypes {

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

        recyclerView = binding.exSetsPlaceholder
        recyclerView.apply {
            adapter = RepsOfSetsAdapter()

            val sets = listOf(
                RepsSets(10, 40),
                RepsSets(20, 20)
            )

            (adapter as RepsOfSetsAdapter).addItems(sets)
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.exerciseFragment.setOnTouchListener(object : OnSwipeListener(requireContext()) {

            override fun onSwipeDown() {
                (recyclerView.adapter as RepsOfSetsAdapter).addItem(RepsSets(0, 0))
                Toast.makeText(requireContext(), "Swipe down", Toast.LENGTH_SHORT).show()
            }

            override fun onSwipeTop() {
                (recyclerView.adapter as RepsOfSetsAdapter)
                    .removeItem((recyclerView.adapter as RepsOfSetsAdapter).itemCount - 1)
                Toast.makeText(requireContext(), "Swipe top", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getFragmentData(): List<ParamOfSet> {
        return (recyclerView.adapter as RepsOfSetsAdapter).getItems()
    }

    override fun setFragmentTitle(title: String) {
        binding.exName.text = title
    }
}
