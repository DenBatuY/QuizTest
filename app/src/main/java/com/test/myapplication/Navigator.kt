package com.test.myapplication

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {
    fun goToGameFragment()
    fun goToResultFragment(score: Int, allQuestionCount: Int)
}
