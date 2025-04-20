package org.wikipedia.homeworks.homework020

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NamedTopReadItems(matcher: Matcher<View>) : KRecyclerItem<NamedTopReadItems>(matcher) {
    val topReadHeaderTitle : KTextView by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Top Header Title"))
    }

    val languageCode: KTextView by lazy {
        KTextView(matcher) {
            withId(R.id.langCodeText)
        }.setName(withParent("Language Code"))
    }

    val imageMenu: KImageView by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("Menu Image"))
    }

    val items: KRecyclerView by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.news_cardview_recycler_view)
            },
            itemTypeBuilder = {
                itemType(::NamedTopReadViewItem)
            }
        ).setName(withParent("Cards"))
    }
}