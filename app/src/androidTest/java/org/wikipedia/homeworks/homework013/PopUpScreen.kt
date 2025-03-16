package org.wikipedia.homeworks.homework013

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import org.wikipedia.R

object PopUpScreen : KScreen<PopUpScreen>() {
    override val layoutId = null
    override val viewClass = null

    val viewPager = KViewPager2(
        builder = {
            withId(R.id.reference_pager)
        },
        itemTypeBuilder = {
            itemType(::PopUpViewItem)
        }
    )

}