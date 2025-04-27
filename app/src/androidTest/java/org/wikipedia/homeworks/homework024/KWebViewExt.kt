package org.wikipedia.homeworks.homework024

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXPath(xPath: String) = KWebViewElement(this, xPath)

inline fun <reified T : KWebViewItem<T>> KWebViewList.invokeAtIndex(
    targetIndex: Int,
    function: T.() -> Unit
) {
    val list: KWebViewList = this
    childAt<T>(targetIndex) {
        name(list.getName().withParent("$targetIndex"))
        executeAction { scroll() }
        function()
    }
}