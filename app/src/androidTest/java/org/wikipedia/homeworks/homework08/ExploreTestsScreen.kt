package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.main.MainActivity

class ExploreTestScreen : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSkipButton() {
        run {
            step("Ensure [Skip] button is displayed") {
                OnboardingScreen.skipButton.isDisplayed()
            }

            step("Ensure [Skip] button is clickable") {
                OnboardingScreen.skipButton.isClickable()
            }
            step("Click [Skip] button") {
                OnboardingScreen.skipButton.click()
            }
            step("Ensure Onboarding is skipped") {
//                ExploreScreen.isDisplayed()
                OnboardingScreen.skipButton.doesNotExist()
            }
        }
    }

    @Test
    fun testAddLanguageButton() {
        run {
            step("Ensure [Add or edit languages] button is displayed and clickable") {
                OnboardingScreen.slider {
                    childAt<OnboardingPagerItem>(0) {
                        addLanguageButton.isDisplayed()
                        addLanguageButton.isClickable()
                    }
                }
            }
        }

    }

    @Test
    fun testContinueButton() {
        run {
            step("Ensure [Continue] button is displayed and clickable") {
                OnboardingScreen.continueButton.isDisplayed()
                OnboardingScreen.continueButton.isClickable()
            }

            step("Click on [Continue] button") {
                OnboardingScreen.continueButton.click()
            }
        }
    }


    @Test
    fun testOnboardingLogoIsDisplayed() {
        run {
            step("Ensure logo is displayed") {
                OnboardingScreen.slider {
                    childAt<OnboardingPagerItem>(0) {
                        logoImage.isDisplayed()
                    }
                }
            }
        }
    }

}

