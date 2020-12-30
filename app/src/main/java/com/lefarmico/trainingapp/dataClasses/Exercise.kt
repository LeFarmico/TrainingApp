package com.lefarmico.trainingapp.dataClasses

data class Exercise(
        var exerciseName: String = "Exercise",
        val defSetsCount: Int = 10,
        var workoutSetsCount: List<WorkoutSet> = mutableListOf())


data class WorkoutSet(
        var reps: Int = 10,
        var weight: Int = 20)
