package org.wikipedia.homeworks.homework019

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework013.ArticleViewScreen
import org.wikipedia.homeworks.homework013.DialogPreviewContainer
import org.wikipedia.homeworks.homework013.PopUpScreen
import org.wikipedia.homeworks.homework013.PopUpViewItem
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.InTheNewsViewItem
import org.wikipedia.main.MainActivity

class WebViewTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            val steps = Steps(this)
            steps {
//            step("Skip Onboarding, navigate to any article") {
//                OnboardingScreen.skipButton.click()
                disableNetwork()
                enableNetwork()
                setOrientationLeft()
                click(OnboardingScreen.skipButton, "Кнопка skip")
                setOrientationRight()


                ExploreScreen.items.childWith<FeaturedArticleItem> {
                    withDescendant {
                        withText("Featured article")
                    }
                }.perform {
                    isVisible(this, "Находим статью 'Featured article'")
                    hasAnyText(title, "any")
                    paused(5000)
                    setOrientationNatural()
                }

                ExploreScreen.items.childAt<FeaturedArticleItem>(3) {
                    click(title, "The 2nd article")
                    isVisible(title, "title")
                }

                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
//                          scroll()
                            hasText("References")
                        }
                    }
                }
            }
        }
    }
}
