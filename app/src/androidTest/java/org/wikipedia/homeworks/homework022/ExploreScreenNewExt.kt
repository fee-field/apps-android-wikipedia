package org.wikipedia.homeworks.homework022

import org.wikipedia.R
import org.wikipedia.homeworks.homework020.getName
import org.wikipedia.homeworks.homework020.setName
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem


//fun ExploreScreen.searchCardViewItem(
//    targetId: Int,
//    targetIndex: Int,
//    limiter: Int,
//    blockName: String,
//    function: SearchCardViewItem.() -> Unit
//) {
//    return items.invokeByID<SearchCardViewItem>(
//        targetId = (R.id.voice_search_button),
//        targetIndex = 1,
////        function = function,
//        blockName = "Search Block",
//        limiter = (4 * targetIndex).coerceAtLeast(5)
//    ) {
//        setName(ExploreScreen.items.getName().withParent("Search Article Block"))
//    }
//}


fun ExploreScreen.searchCardViewItem(function: SearchCardViewItem.() -> Unit) {
    items.invokeByID<SearchCardViewItem>(
        targetId = R.id.voice_search_button,
        targetIndex = 1,
        blockName = "Search block",
        limiter = 5,
        function = function
    )
}

fun ExploreScreen.searchCardViewItem(
    index: Int,
    targetId: Int,
    limiter: Int,
    blockName: String,
    targetIndex: Int,
): SearchCardViewItem {
    return items.findByID<SearchCardViewItem>(
        targetId = (R.id.voice_search_button),
        targetIndex = 1,
        blockName = "Search Block",
        limiter = (4 * targetIndex).coerceAtLeast(5)
    )
}

fun ExploreScreen.featuredArticleItem(
    targetId: Int,
    limiter: Int,
    blockName: String,
    targetIndex: Int,
    function: FeaturedArticleItem.() -> Unit
) {
    return items.invokeByID<FeaturedArticleItem>(
        targetId = (R.id.articleImage),
        targetIndex = 0,
        blockName = "Featured Article block",
        limiter = (4 * targetIndex).coerceAtLeast(5)
    ) {
        setName(ExploreScreen.items.getName().withParent("Featured Article Block"))
    }
}


fun ExploreScreen.featuredArticleItem(
    index: Int,
    targetId: Int,
    limiter: Int,
    blockName: String,
    targetIndex: Int,
): FeaturedArticleItem {
    return this.items.findByID<FeaturedArticleItem>(
        targetId = (R.id.articleImage),
        targetIndex = 0,
        blockName = "Featured Article block",
        limiter = (4 * targetIndex).coerceAtLeast(5)
    )
}

