package org.wikipedia.homeworks.homework023

import org.wikipedia.R
import org.wikipedia.homeworks.homework020.NamedKScreen
import org.wikipedia.homeworks.homework020.setName

object ExploreScreenWithWidget : NamedKScreen<ExploreScreenWithWidget>() {
    override val screenName: String = "Explore Screen"
    override val layoutId = null
    override val viewClass = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.setName(withParent("search widget"))
    }

    val topReadWidget by lazy {
        TopReadWidget {
            isDescendantOfA { withId(R.id.feed_view) }
            withDescendant { withText("Top read") }
        }.setName(withParent("TopRead widget"))
    }

}