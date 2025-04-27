package org.wikipedia.homeworks.homework023


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework020.namedSteps
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WidgetTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWithWidget() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenWithWidget.searchWidget {
                    isVisible(searchVoiceIcon)
                }
                ExploreScreenWithWidget.topReadWidget {
                    isVisible(topReadHeaderTitle)
                }


            }
        }
    }
}