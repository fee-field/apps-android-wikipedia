package org.wikipedia.homeworks.homework023

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher

open class KWidget<T> : KBaseView<T> {

    val parent: Matcher<View>

    constructor(function: ViewBuilder.() -> Unit) : super(function) {
        parent = ViewBuilder().apply(function)
            .getViewMatcher() //собрали все матчеры в один, function - матчеры через функцию
    }

    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher,function) {
        parent = ViewBuilder().apply {
            function()
            isDescendantOfA { // матчер, говорит, что должен быть предок, удовлетворяющий такому-то матчеру
                withMatcher(matcher) // элемент в качестве родительского должен соответствоввать ..
            }
        }.getViewMatcher()
    }
}



