package org.wikipedia.homeworks.homework021

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class HasDrawableAssertion : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is ImageView) {
//          Assert.assertTrue("Is drawable", view.drawable)
            Assert.assertNotNull("There is no KImageView", view.drawable)
        } else {
            throw (noViewFoundException ?: AssertionError("View is not КImageView"))
        }
    }
}