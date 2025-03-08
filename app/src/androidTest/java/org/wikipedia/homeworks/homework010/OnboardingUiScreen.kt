package org.wikipedia.homeworks.homework010

import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val title = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val description = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val languageList = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "languagesList")
    }

    val languageItem = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "option_label")
    }

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val pagesList = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }

    val pageThird = UiView {
        withIndex(5) {
            withClassName("android.widget.LinearLayout")
        }
    }

    val pager = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "scrollViewContainer")
    }

    val customizeButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "view_announcement_action_positive")
    }
}
