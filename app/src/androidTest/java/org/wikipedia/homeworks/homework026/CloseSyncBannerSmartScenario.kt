package org.wikipedia.homeworks.homework026


    import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
    import com.kaspersky.kaspresso.testcases.models.info.StepInfo
    import io.github.kakaocup.kakao.common.views.KView

class CloseSyncBannerSmartScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
        override val stepInfo: String = "Закрывает окно с предложением синхронизации списка чтения"
        override val action: (StepInfo) -> Unit = {
            KView {
                withId(android.R.id.button2)
            }.click()
        }

        override fun isConditionMet() = waitElementByText("reading list")
    }