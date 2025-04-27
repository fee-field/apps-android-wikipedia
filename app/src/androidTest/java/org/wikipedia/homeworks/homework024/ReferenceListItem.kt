package org.wikipedia.homeworks.homework024

import io.github.kakaocup.kakao.web.KWebView

class ReferenceListItem(kWebView: KWebView, xPath: String) :
    KWebViewItem<ReferenceListItem>(kWebView, xPath) {
    override val self: ReferenceListItem = this

    val index by lazy {
        child<KWebViewElement>("/div/div[1]")
            .name(withParent("element index"))
    }

    val content by lazy {
        child<KWebViewElement>("/div/div[2]/span")
            .name(withParent("Element contains .."))
    }
}