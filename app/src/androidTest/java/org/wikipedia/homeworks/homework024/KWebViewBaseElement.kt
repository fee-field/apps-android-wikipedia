package org.wikipedia.homeworks.homework024

import io.github.kakaocup.kakao.web.KWebView
import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.web.WebElementBuilder.KWebInteraction
import org.wikipedia.homeworks.homework020.NameHierarchyClass

abstract class KWebViewBaseElement<T : KWebViewBaseElement<T>>(
    val kWebView: KWebView,
    val xPath: String
) {
    abstract val self: T
    private var name: NameHierarchyClass = NameHierarchyClass("No label")

    inline fun <reified T: KWebViewBaseElement<T>> child(childXPath: String): T {
        return T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(kWebView, "${this.xPath}$childXPath")
    }

    operator fun invoke(function: T.() -> Unit) {
        function(self)
    }

    infix fun perform(function: T.() -> Unit): T {
        function(self)
        return self
    }

    fun executeAction(interaction: KWebInteraction.() -> Unit) {
        kWebView {
            withElement(Locator.XPATH, xPath, interaction)
        }
    }

    fun name(name: NameHierarchyClass): T {
        this.name = name
        return self
    }

    fun getName(): NameHierarchyClass = name

    fun withParent(elementName: String) = NameHierarchyClass(elementName, name)


}