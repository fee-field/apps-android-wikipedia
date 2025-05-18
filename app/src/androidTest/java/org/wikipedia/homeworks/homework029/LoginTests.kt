package org.wikipedia.homeworks.homework029

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework020.namedSteps
import org.wikipedia.homeworks.homework022.ExploreScreenNew
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class LoginTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun login() {
        run {
            namedSteps {
                OnboardingScreen {
                    click(skipButton)
                }
                ExploreScreenNew {
                    click(moreButton)
                }
                MoreScreen {
                    click(loginButton)
                }
                CreateAccountScreen {
                    click(loginButton)
                }
                LoginScreen {
                    val login = Users.blaLogin
                    authorize(login)
                    paused(5000)
                }

            }
        }
    }


}