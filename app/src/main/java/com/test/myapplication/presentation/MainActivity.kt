package com.test.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.myapplication.Navigator
import com.test.myapplication.R

class MainActivity : AppCompatActivity(), Navigator {
    private val containerView = R.id.container
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.replaceNow(containerView, WelcomeFragment())
        }
    }

    override fun goToGameFragment() =
        supportFragmentManager.replaceNow(containerView, GameFragment())

    override fun goToResultFragment(score: Int, allQuestionCount: Int) = supportFragmentManager
        .replaceNow(containerView, ResultFragment.newInstance(score, allQuestionCount))
}