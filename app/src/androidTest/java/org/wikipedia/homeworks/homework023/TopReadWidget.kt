package org.wikipedia.homeworks.homework023

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework020.invokeAtIndex
import org.wikipedia.homeworks.homework020.setName
import org.wikipedia.homeworks.homework023.ExploreScreenWithWidget.withParent


class TopReadWidget : KWidget<TopReadWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val topReadHeaderTitle by lazy {
        KTextView(parent) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Top Read element header"))
    }

    val cardOptionsMenuImage by lazy {
        KImageView(parent) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("Top Read settings icon"))
    }

    val footerContainer by lazy {
        KImageView(parent) {
            withId(R.id.footerActionButton)
        }.setName(withParent("Top Read footer container"))
    }

    val topReadItems by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadCardViewItem)
            }
        ).setName(withParent("Top Read list items"))
    }

    fun topReadWidgetItems(index: Int, function: TopReadCardViewItem.() -> Unit) {
        topReadItems.invokeAtIndex(index, function)
    }
}