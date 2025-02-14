package org.wikipedia.homeworks.homework05

import android.widget.LinearLayout
import androidx.compose.ui.test.isToggleable
import com.google.android.material.button.MaterialButton
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.views.DiscreteSeekBar

val switch = KSwitch {
    isInstanceOf(MaterialSwitch::class.java)
    withId(R.id.theme_chooser_match_system_theme_switch)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
    isToggleable()
}

val readingFocusModeBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
    isInstanceOf(DiscreteSeekBar::class.java)
    isClickable()
    withText(R.string.reading_focus_mode)
}

val fontButtonFirst = KButton {
    withId(R.id.button_font_family_sans_serif)
    isClickable()
    withText("sans-serif")
    isInstanceOf(MaterialButton::class.java)
}

val fontButtonSecond = KButton {
    withId(R.id.button_font_family_serif)
    isClickable()
    withoutText("sans")
    isInstanceOf(MaterialButton::class.java)
}

val matchSystemThemeBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
    isInstanceOf(DiscreteSeekBar::class.java)
    isClickable()
    withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
}

val buttonThemeLight = KButton {
    withId(R.id.button_theme_light)
    isClickable()
    isInstanceOf(MaterialButton::class.java)
}

val buttonThemeSepia = KButton {
    withId(R.id.button_theme_sepia)
    isClickable()
    isInstanceOf(MaterialButton::class.java)
}

val themeHeader = KTextView {
    isInstanceOf(MaterialTextView::class.java)
    withText("Theme")
    withParent {
        isInstanceOf(LinearLayout::class.java)

    }
}

val ReadingHeader = KTextView {
    isInstanceOf(MaterialTextView::class.java)
    withText(R.string.theme_category_reading)
    withParent {
        isInstanceOf(MaterialTextView::class.java)
    withId(R.id.textSettingsCategory)
    }
}

val textSizeDecreaseButton = KButton {
    withId(R.id.buttonDecreaseTextSize)
    withText(R.string.text_size_decrease)
    isInstanceOf(LinearLayout::class.java)
}

val textSizeIncreaseButton = KButton {
    withId(R.id.buttonIncreaseTextSize)
    withText(R.string.text_size_increase)
    isInstanceOf(LinearLayout::class.java)
}

val textSizePercentageView = KView {
    withId(R.id.text_size_percent)
    containsText("%")
}