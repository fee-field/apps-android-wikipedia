package org.wikipedia.homeworks.homework023

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework020.setName
import org.wikipedia.homeworks.homework023.ExploreScreenWithWidget.withParent

class SearchWidget : KWidget<SearchWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val searchIcon by lazy {
        KImageView(parent) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.setName(withParent("search icon"))
    }

    val searchVoiceIcon by lazy {
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.setName(withParent("search voice icon"))
    }

}