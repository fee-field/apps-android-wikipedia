package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object NewsScreen : KScreen<NewsScreen>() {
    override val layoutId = null
    override val viewClass = null

    val storyImage = KImageView{
        withId(R.id.header_image_view)
    }

    val storyTextViw = KTextView{
        withId(R.id.story_text_view)
    }

    val storyItems = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::NewsStoryItemView)
        }
    )
}