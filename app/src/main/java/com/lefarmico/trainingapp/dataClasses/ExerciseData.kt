package com.lefarmico.trainingapp.dataClasses

data class ExerciseData(
    val title: String = "Exercise",
    val sets: List<SetTypesData> = mutableListOf()
)

sealed class SetTypesData
data class RepsType(
    val reps: Int = 10,
    val weight: Int = 20
) : SetTypesData()
