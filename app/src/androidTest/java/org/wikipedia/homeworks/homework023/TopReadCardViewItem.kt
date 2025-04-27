package org.wikipedia.homeworks.homework023

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework020.setName
import org.wikipedia.homeworks.homework020.withParent

class TopReadCardViewItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardViewItem>(matcher) {

    val baseNumberView by lazy{
        KTextView(matcher) {
            withId(R.id.baseNumberView)
        }
    }
    val numberView by lazy{
        KTextView(matcher) {
            withId(R.id.numberView)
        }
    }
    val cardItemTitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }
    }
    val cardItemSubtitle by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }
    }
    val cardItemGraph by lazy{
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }
    }
    val cardItemPageViews by lazy{
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }
    }
    val cardItemImage by lazy{
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }
    }
}