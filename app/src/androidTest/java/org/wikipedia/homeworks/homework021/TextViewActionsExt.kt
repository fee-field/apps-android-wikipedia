package org.wikipedia.homeworks.homework021

import android.widget.TextView
import io.github.kakaocup.kakao.text.TextViewActions

fun TextViewActions.getText(): String {
    val text = GetText()
    view.perform(text)
    return text.getText()
}