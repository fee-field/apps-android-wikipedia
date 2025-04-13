package org.wikipedia.homeworks.homework020

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework020.ExploreScreenNew.withParent

class NamedTopReadItems(matcher: Matcher<View>) : KRecyclerItem<NamedTopReadItems>(matcher) {
    val topReadHeaderTitle by lazy { KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }.name(
        withParent("Top Header Title")) }
    val languageCode = KTextView(matcher) {
        withId(R.id.langCodeText)
    }
    val imageMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val cardViewItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::NamedTopReadViewItem)
        }
    )
}