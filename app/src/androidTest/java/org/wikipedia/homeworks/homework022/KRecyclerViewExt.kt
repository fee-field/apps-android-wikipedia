package org.wikipedia.homeworks.homework022

import android.content.res.Resources.NotFoundException
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework020.getName
import org.wikipedia.homeworks.homework020.setName
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeByID(
    targetIndex: Int,
    targetId: Int,
    blockName: String,
    limiter: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    recycler.getSize()
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId))
                findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
                return
            }
        }
    }
    throw NotFoundException("Not found block with $targetIndex index of $blockName")
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findByID(
    targetIndex: Int,
    targetId: Int,
    limiter: Int,
    blockName: String,
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    recycler.getSize()
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId))
                findBlockCounter++
            if (findBlockCounter == targetIndex) {
                setName(recycler.getName().withParent("$targetIndex's block of $blockName"))
                return this
            }
        }
    }
    throw NotFoundException("Not found")
}