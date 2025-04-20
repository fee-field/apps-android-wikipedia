package org.wikipedia.homeworks.homework021

import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.customClick() {
    view.perform(CustomViewAction())
}