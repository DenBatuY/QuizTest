package com.test.myapplication.presentation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceNow(
    @IdRes containerId: Int,
    fragment: Fragment,
    addBackStack: Boolean = false,
    replace: Boolean = true
) {
    val transaction = if (replace) {
        beginTransaction()
            .replace(containerId, fragment, fragment.tag)
    } else {
        beginTransaction()
            .add(containerId, fragment, fragment.tag)
    }
    if (addBackStack) {
        transaction.addToBackStack(fragment::class.simpleName)
    }
    transaction.commit()
}