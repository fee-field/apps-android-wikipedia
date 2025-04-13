package org.wikipedia.homeworks.homework020

class NameHierarchyClass(val name: String, val parent: NameHierarchyClass? = null) {
    fun withParent(currentElementName: String) = NameHierarchyClass(currentElementName, this)
    override fun toString(): String {
        return if (parent == null) name
        else "$parent : $name"
    }
}