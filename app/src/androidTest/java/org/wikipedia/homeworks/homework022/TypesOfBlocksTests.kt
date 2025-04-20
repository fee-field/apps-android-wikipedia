package org.wikipedia.homeworks.homework022

import NamedSteps
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework019.steps
import org.wikipedia.homeworks.homework020.ExploreScreenNew
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class TypesOfBlocksTests() : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun typesOfBlocks() {
        run {
            steps {
                click(OnboardingScreen.skipButton, "search button")
                ExploreScreenNew.searchCardViewItem {
                    searchText.hasText("Search Wikipedia")
                    voiceSearchButton.isVisible()
               }
            }
        }
    }
}


