package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R

object WikiArticleCardView : KScreen<WikiArticleCardView>() {
    override val layoutId = null
    override val viewClass = null

    val articleTitle = KImageView {
        withId(R.id.articleTitle)
    }

    val articlePageView = KView {
        withId(R.id.page_web_view)
    }
}