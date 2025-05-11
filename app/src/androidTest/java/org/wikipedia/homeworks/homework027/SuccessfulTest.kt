package org.wikipedia.homeworks.homework027

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework020.namedSteps
import org.wikipedia.homeworks.homework022.ExploreScreenNew
import org.wikipedia.homeworks.homework022.searchCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity


class SuccessfulTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
//        stepWatcherInterceptors.add(FailOnlyScreenshotStepInterceptor(screenshots))
        testRunWatcherInterceptors.add(SuccessFinalScreenshotTestInterceptor(screenshots))
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun successfulTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenNew.searchCardViewItem {
                    searchText.hasText("Search Wikipedia")
                }
            }
        }
    }
}