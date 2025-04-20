package org.wikipedia.homeworks.homework021

import android.view.View
import android.widget.Checkable
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher


class CheckBoxAction : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "toggle checkbox"
    }

    override fun perform(uiController: UiController?, view: View?) {
        if (view is Checkable) {
            view.isChecked = !view.isChecked
        } else {
            throw IllegalStateException("View does not have Checkable action")
        }
    }
}
