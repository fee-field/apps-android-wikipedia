package org.wikipedia.homeworks.homework011

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class DeviceTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        before {
            device.language.switchInApp(Locale.ENGLISH)
        }.after {
            device.network.enable()
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }.run {
            step("Rotate screen and check orientation") {
                device.exploit.rotate()
                device.uiDevice.isNaturalOrientation

            }
            step("Turn off the screen, turn on and ensure Skip button is displayed") {
                device.uiDevice.sleep()
                Thread.sleep(3000)
                device.uiDevice.wakeUp()
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Minimize the app, reopen it and ensure the logo image is displayed") {
                device.uiDevice.pressHome()
                device.apps.openRecent("WikipediaApp")
                OnboardingScreen.logo.isDisplayed()
            }
            step("Disable network, navigate to any article and check the error is showing") {
                device.network.disable()
                ExploreScreen.items.childWith<TopReadItem> {
                    withDescendant {
                        withText("Top")
                    }
                }.perform {
                    topReadHeaderTitle.hasAnyText()
                }
// ???? и проверить отображение ошибки и кнопки Retry.
            }
            step("Change the app language") {
                device.language.switchInApp(Locale.ITALIAN)
                device.uiDevice.findObject(UiSelector().resourceId("location_permissions_enable_action")).text
//   проверить текст какой-нибудь кнопки ????
                }

            step("Ensure MainActivity is currently active") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }

}
