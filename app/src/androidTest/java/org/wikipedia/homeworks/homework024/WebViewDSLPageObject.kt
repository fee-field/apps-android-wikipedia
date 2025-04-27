package org.wikipedia.homeworks.homework024

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework020.NamedKScreen

object WebViewDSLPageObject : NamedKScreen<WebViewDSLPageObject>() {
    override val screenName: String = "WebViewDSL"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }
    val referencesHeader by lazy {
        KWebViewElement(webView, "//div[contains(@class, 'pcs-edit-section-header')]//h2[@id='References']")
            .name(withParent("References List Header"))
    }
    val reference by lazy {
        KWebViewList(webView, "//ol[@class='mw-references references']")
            .name(withParent("References List"))
    }
    fun getReferencesList(index: Int, function: ReferenceListItem.() -> Unit) {
        reference.childAt<ReferenceListItem>(index, function)
    }
}