package org.wikipedia.homeworks.homework020

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NamedTopReadViewItem(matcher: Matcher<View>) : KRecyclerItem<NamedTopReadViewItem>(matcher) {
    val cardItemTitle: KImageView by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.setName(withParent("Card Item Title"))
    }

    val cardItemImage: KImageView by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.setName(withParent("Card Item Image"))
    }
}