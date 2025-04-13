package org.wikipedia.homeworks.homework018

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.InTheNewsViewItem
import org.wikipedia.homeworks.homework09.NewsCardViewItem
import org.wikipedia.homeworks.homework09.NewsScreen
import org.wikipedia.homeworks.homework09.NewsStoryItemView
import org.wikipedia.homeworks.homework09.WikiArticleCardView
import org.wikipedia.main.MainActivity

class SkipOnboardingTestScreen :
    TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

//    @After
//    fun tearDown() {
//        device.files.pull("/sdcard/Documents/allure-results", "app/build")
//    }

    @Test
    fun skipOnboarding() {
        run {
            step("Skip Onboarding") {
                OnboardingScreen.skipButton.click()
            }
            step("Search for [In the News] block") {
                ExploreScreen.items.childWith<InTheNewsViewItem> {
                    withDescendant {
                        withText("In the news")
                    }

                }.perform {
                    newsHeader.hasAnyText()
                }
            }

            step("Click on the 3rd image block") {
                ExploreScreen.items.childWith<InTheNewsViewItem> {
                    withDescendant {
                        withText("In the news")
                    }

                }.perform {
                    newsCardItems.childAt<NewsCardViewItem>(2) {
                        newsArticleImage.click()
                    }
                }

            }
            step("Click on the 2nd article from the list") {
                NewsScreen.storyItems.childAt<NewsStoryItemView>(1) {
                    listCardItemTitle.click()
                }
            }
            step("Ensure that Element with ID = page_web_view is displayed") {
                WikiArticleCardView.articlePageView.isDisplayed()
            }
        }
    }
}