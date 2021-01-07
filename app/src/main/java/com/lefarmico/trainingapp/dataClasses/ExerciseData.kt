package com.lefarmico.trainingapp.dataClasses

data class Exercise(
    val exerciseName: String = "Exercise",
    val defSetsCount: Int = 10,
    val workoutSetsCount: List<ParamOfSet> = mutableListOf()
)

sealed class ParamOfSet
data class RepsSets(
    val reps: Int = 10,
    val weight: Int = 20
) : ParamOfSet()
