@file:JvmName("NewsViewItemKt")

package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsViewItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsViewItem>(matcher) {

    val newsHeader = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val newsCustomizeFeedOptions = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val newsCardItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::NewsCardViewItem)
        }
    )
}





