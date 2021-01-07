package com.lefarmico.trainingapp.fragments

abstract class FragmentFactory {
    abstract fun createFragment(): IExerciseFragmentTypes

    companion object {
        inline fun <reified T : IExerciseFragmentTypes> createFactory(): FragmentFactory =
            when (T::class) {
                ExerciseFragment::class -> ExerciseFragmentFactory()
                else -> throw IllegalArgumentException()
            }
    }
}
class ExerciseFragmentFactory() : FragmentFactory() {
    override fun createFragment(): IExerciseFragmentTypes = ExerciseFragment()
}
