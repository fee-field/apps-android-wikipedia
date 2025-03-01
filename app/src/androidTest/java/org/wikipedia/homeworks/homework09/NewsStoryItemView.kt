package org.wikipedia.homeworks.homework09

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsStoryItemView(matcher: Matcher<View>) : KRecyclerItem<NewsStoryItemView>(matcher){

    val listCardNumber = KView(matcher) {
        withId(R.id.view_list_card_number)
    }

    val listCardItemTitle = KTextView(matcher) {
       withId(R.id.view_list_card_item_title)
    }

    val listCardItemSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val listCardItemGraph = KTextView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val listCardItemPageView = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val cardItemImage = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}