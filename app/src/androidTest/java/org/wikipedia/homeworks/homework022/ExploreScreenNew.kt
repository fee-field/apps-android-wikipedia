package org.wikipedia.homeworks.homework022

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework020.NamedKScreen
import org.wikipedia.homeworks.homework020.NamedTopReadItems
import org.wikipedia.homeworks.homework020.getName
import org.wikipedia.homeworks.homework020.setName
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

    val toolbarTitle: KImageView by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.setName(withParent("Toolbar title"))
    }

    val moreButton by lazy {
        KView{
            withId(R.id.nav_tab_more)
        }.setName(withParent("More button"))
    }

    val searchIcon: KImageView by lazy {
        KImageView {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.setName(withParent("Search Icon"))
    }

    val customizeButton: KButton by lazy {
        KButton {
            withId(R.id.view_announcement_action_positive)
        }.setName(withParent("Customize Button"))
    }

    val items: KRecyclerView by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            }, itemTypeBuilder = {
                itemType(::SearchCardViewItem)
                itemType(::DayHeaderCardViewItem)
                itemType(::AnnouncementCardViewItem)
                itemType(::NamedTopReadItems)
                itemType(::InTheNewsViewItem)
                itemType(::FeaturedArticleItem)
            }).setName(withParent("List of Blocks"))
    }


    fun announcementItemById(targetIndex: Int, function: TopReadItem.() -> Unit) {
//        items.childAt<TopReadItem>(index) {
//            name(this@ExploreScreenNew.items.getName().withParent("$index"))
//            this.name(withParent("$index"))
//            function()
        items.invokeByID(
            targetIndex = targetIndex,
            targetId = R.id.view_announcement_text,
            blockName = "Announcement Card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function)
    }
    fun searchItemById(targetIndex: Int, function: TopReadItem.() -> Unit) {
        items.invokeByID(
            targetIndex = targetIndex,
            targetId = R.id.voice_search_button,
            blockName = "Search",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function)
    }



    fun topReadItem() : NamedTopReadItems {
       return items.childWith<NamedTopReadItems> {
            withDescendant {
                withText("Top Read")
            }
        }.setName(items.getName().withParent("Top Read Item block"))
    }
}