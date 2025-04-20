package org.wikipedia.homeworks.homework020

import io.github.kakaocup.kakao.common.actions.BaseActions

    val names = mutableMapOf<BaseActions, NameHierarchyClass>()

    fun <T : BaseActions> T.setName(hierarchyClass: NameHierarchyClass): T {
        names[this] = hierarchyClass
        return this
    }
    fun BaseActions.getName() : NameHierarchyClass {
        return names[this] ?: throw RuntimeException ("set name")
    }

fun BaseActions.withParent(elementName: String) = getName().withParent(elementName)
