package org.wikipedia.homeworks.homework013

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.InTheNewsViewItem
import org.wikipedia.main.MainActivity

class WebViewTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            step("Skip Onboarding, navigate to any article") {
                OnboardingScreen.skipButton.click()
                ExploreScreen.items.childWith<FeaturedArticleItem> {
                    withDescendant { withText("Featured article") }
                }.perform {
                    isDisplayed()
                    }
                }
            step("Click the article name") {
                ExploreScreen.items.childAt<FeaturedArticleItem>(3) {
                    title.click()
                }

            }

            step("Scroll to Element with Id = 'References' and verify text of the element") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
            step("Click on the Element (5th link)") {
                ArticleViewScreen {
                    webView {
                        withElement(
                            Locator.XPATH,
                            "//a[@class='reference-link' and .//text()='5']"
                        ) {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Verify text on the pop up window") {
                PopUpScreen.viewPager.childAt<PopUpViewItem>(0) {
                    refId.isDisplayed()
                    refId.containsText("O'Brien")
                    refId.containsText("5")
                }
            }
            step("Close pop up window using Back button") {
                device.uiDevice.pressBack()
            }
            step("Search for the second link where CSS class = mw-redirect and click on it") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.CSS_SELECTOR, ".mw-redirect:nth-child(1)") {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Click [Read Article] button on the pop up window") {
                DialogPreviewContainer.readArticleButton.click()
            }
            step("Scroll to Element with Id = 'References' and verify text of the element") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
        }
    }

}