package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.articleImage)
    }

    val title = KTextView(matcher) {
        withId(R.id.articleTitle)
    }
}