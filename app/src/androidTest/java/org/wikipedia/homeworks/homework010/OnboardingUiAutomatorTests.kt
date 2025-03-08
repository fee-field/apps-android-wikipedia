package org.wikipedia.homeworks.homework010

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun onboardingSwipeAndCheckText() {
        run {
            step("Swipe to the second page") {
                flakySafely(timeoutMs = 5000) {
                    OnboardingUiScreen.pager.swipeLeft(0.25f)
//                Thread.sleep(2000)
                }
            }
//            step("Verify there is a match with a text on the second page") {
//                OnboardingUiScreen.title.containsText("New way to")
//            }
        }
    }

    @Test
    fun onboardingContinueAndCheckText() {
        run {
            step("Ensure [Continue] button is present on the page") {
                OnboardingUiScreen.continueButton.isDisplayed()
            }
            step("Click on [Continue] button to navigate to the next page") {
                OnboardingUiScreen.continueButton.click()
            }
            step("Verify there is a match with a text on the second page") {
                OnboardingUiScreen.title.containsText("New ways to")
            }
        }
    }

    @Test
    fun onboardingPageNavigation() {
        run {
            step("Navigate to the third page") {
                OnboardingUiScreen.pageThird.click()
            }
            step("Verify there is a match with a text on the second page") {
                OnboardingUiScreen.title.containsText("Reading lists with sync")
            }
        }
    }

    @Test
    fun onboardingSkip() {
        run {
            step("Skip Onboarding and verify there is a match with a text on the Explore page") {
                OnboardingUiScreen.skipButton.click()
                OnboardingUiScreen.customizeButton.isDisplayed()
            }
        }
    }

}