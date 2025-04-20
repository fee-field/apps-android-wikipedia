package org.wikipedia.homeworks.homework021

import androidx.test.espresso.Root
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.delegate.ViewInteractionDelegate
import io.github.kakaocup.kakao.image.ImageViewAssertions
import org.hamcrest.Matcher

//fun ImageViewAssertions.noDrawable() {
//    view.check(HasNoDrawableAssertion())
//}

fun BaseAssertions.noDrawable() {
    view.check(HasNoDrawableAssertion())
}