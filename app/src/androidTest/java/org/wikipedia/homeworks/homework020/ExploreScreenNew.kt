package org.wikipedia.homeworks.homework020

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework09.InTheNewsViewItem

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val screenName = "Main Screen"

    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle: KImageView = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("toolbar title"))

    val searchIcon: KImageView = KImageView {
        KImageView {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.name(withParent("Search Icon")
    }

    val customizeButton: KButton = KButton {
        KButton {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Customize Button")
    }

    val items = KRecyclerView(builder = {
        withId(R.id.feed_view)
    }, itemTypeBuilder = {
        itemType(::SearchCardViewItem)
        itemType(::DayHeaderCardViewItem)
        itemType(::AnnouncementCardViewItem)
        itemType(::TopReadItem)
        itemType(::InTheNewsViewItem)
        itemType(::FeaturedArticleItem)
    }).name(withParent("List of Blocks"))


    fun topReadItem(index: Int, function: TopReadItem.() -> Unit) {
        items.childAt<TopReadItem>(index) {
            name(this@ExploreScreenNew.items.getName().withParent("$index"))
            this.name(withParent("$index"))
            function()
        }
    }

    fun topReadItemText() {
        items.childWith<TopReadItem> {
            withDescendant {
                withText("Top Read")
            }
        }.name(withParent("Top Read Item block")
    }
}