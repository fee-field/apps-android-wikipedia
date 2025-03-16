package org.wikipedia.homeworks.homework013

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object DialogPreviewContainer : KScreen<DialogPreviewContainer>() {
    override val layoutId = null
    override val viewClass = null

    val openInNewTabButton = KButton {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticleButton = KButton {
        withId(R.id.link_preview_primary_button)
    }

}