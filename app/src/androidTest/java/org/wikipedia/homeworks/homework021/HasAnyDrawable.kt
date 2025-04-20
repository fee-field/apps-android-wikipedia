package org.wikipedia.homeworks.homework021

import androidx.test.espresso.Root
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.delegate.ViewInteractionDelegate
import io.github.kakaocup.kakao.image.ImageViewAssertions
import org.hamcrest.Matcher

//fun ImageViewAssertions.hasAnyDrawable() {
//    view.check(HasDrawableAssertion())
//}

fun BaseAssertions.hasAnyDrawable() {
    view.check(HasDrawableAssertion())
}