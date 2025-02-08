package org.wikipedia.homeworks.homework03

import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import org.wikipedia.navtab.NavTabLayout
import org.wikipedia.views.FaceAndColorDetectImageView
import org.wikipedia.views.WikiCardView

val mainToolbar = listOf(
    MaterialToolbar::class.java,
    "main_toolbar",
    null
)

val searchButton = listOf(
    WikiCardView::class.java,
    "search_container",
    "search_hint"
)

val announcementHeaderImage = listOf(
    FaceAndColorDetectImageView::class.java,
    "view_announcement_header_image",
    null
)

val announcementHeaderText = listOf(
    FaceAndColorDetectImageView::class.java,
    "view_announcement_text",
    "preference_summary_customize_explore_feed"
)

val negativeButton = listOf(
    MaterialButton::class.java,
    "view_announcement_action_negative",
    "feed_configure_onboarding_action"
)

val positiveButton = listOf(
    MaterialButton::class.java,
    "view_announcement_action_positive",
    "onboarding_got_it"
)

val navigationTabLayout = listOf(
    NavTabLayout::class.java,
    "main_nav_tab_layout",
    null
)


