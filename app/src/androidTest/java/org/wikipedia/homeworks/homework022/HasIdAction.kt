package org.wikipedia.homeworks.homework022

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(
    private val nameId: Int
) : ViewAction {
    private var result: Boolean = false
    fun isMatched() = result
    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Action"
    }

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) {
            throw RuntimeException("View is not found")
        }
        if (view.id == nameId) {
            result = true
        } else {
            val foundView = view.findViewById<View>(nameId)
            result = foundView != null
        }
    }

}

class HasClassAction(
    private val targetClass: Class<out View>
) : ViewAction {
    private var result: Boolean = false
    fun isMatched() = result
    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "checks if the view has a target Class"
    }

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) {
            throw RuntimeException("View is not found")
        }

        result = if (targetClass.isAssignableFrom(view::class.java)) {
            true
        } else {
    //            if (view is ViewGroup) {
    //                checkInnerView(view)
            checkInnerView(view)
        }
    }


    private fun checkInnerView(checkable: View): Boolean {
        if (targetClass.isAssignableFrom(checkable::class.java)) return true
        if (checkable is ViewGroup) {
            checkable.children.forEach {
                if (checkInnerView(it)) return true
            }
        }
        return false
    }
}