package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework020.ExploreScreenNew.withParent
import org.wikipedia.homeworks.homework020.setName

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId = R.layout.fragment_onboarding_pager

    override val viewClass = null

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerItem)
        }
    )
    val skipButton: KButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.setName(withParent("Кнопка 'Skip'"))
    }

    val continueButton = KButton{
        withId(R.id.fragment_onboarding_forward_button)
    }

    val doneButton = KButton{
        withId(R.id.fragment_onboarding_done_button)
    }

    val logo = KImageView{
        withId(R.id.imageViewCentered)
    }
}