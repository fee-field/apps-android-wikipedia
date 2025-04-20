package org.wikipedia.homeworks.homework021

import io.github.kakaocup.kakao.check.KCheckBox

fun KCheckBox.toggle() {
    view.perform(CheckBoxAction())
}