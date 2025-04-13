package org.wikipedia.homeworks.homework020

import io.github.kakaocup.kakao.common.actions.BaseActions

    val names = mutableMapOf<BaseActions, HierarchyClass>()

    fun <T : BaseActions> T.name(hierarchyClass: HierarchyClass): T {
        names[this] = hierarchyClass
        return this
    }
    fun BaseActions.getName() : HierarchyClass {
        return names[this] ?: throw RuntimeException ("set name")
    }

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)
