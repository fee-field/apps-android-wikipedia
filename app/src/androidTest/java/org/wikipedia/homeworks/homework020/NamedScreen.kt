package org.wikipedia.homeworks.homework020

import com.kaspersky.kaspresso.screens.KScreen

abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>() {

    abstract val screenName: String
    val nameHierarchy by lazy { NameHierarchyClass(screenName) }

    fun withParent(elementName: String) = nameHierarchy.withParent(elementName)
}
