package org.wikipedia.homeworks.homework013

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class PopUpViewItem(matcher: Matcher<View>) : KViewPagerItem<PopUpViewItem>(matcher) {

    val refId = KTextView {
        withId(R.id.reference_id)
    }
}