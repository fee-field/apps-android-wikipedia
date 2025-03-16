package org.wikipedia.homeworks.homework012

import androidx.test.espresso.AmbiguousViewMatcherException
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

class TestClass : TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced{
        flakySafetyParams = FlakySafetyParams.custom(
            timeoutMs = 30000,
            allowedExceptions = FlakySafetyParams.defaultAllowedExceptions.plus(AmbiguousViewMatcherException::class.java)
        )
    }
)

/*Конфигуратор Kaspresso
Класс Kaspresso — это единственная точка для установки параметров Kaspresso.
Разработчик может настроить Kaspresso, установив Kaspresso.Builder в конструкторах TestCase, BaseTestCase, TestCaseRule, BaseTestCaseRule.
Пример:

class SomeTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        beforeEachTest {
            testLogger.i("The beginning")
        }
        afterEachTest {
            testLogger.i("The end")
        }
    }
) {
    // ваш тест
}
Структура
Конфигурация Kaspresso содержит:

Kakao clicks
Kaspresso предоставляет возможность переопределить кастомные клики Espresso. Kakao библиотека предоставляет набор подготовленных имплементаций кликов, которые улучшают стабильность тестов на девайсах, находящихся под большой нагрузкой.

Все детали о проблеме и решениях описано в Kakao документации.

Пример, как заиспользовать кастомные клики в вашем тесте, представлен в CustomClickTest.

class ClickTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple(
        customize = {
            clickParams = ClickParams.kakaoVisual()
        }
    )
) {
    // your test
}
Kaspresso предоставляет следующие подготовленные опции для кастомизации кликов: 1. ClickParams.kakaoVisual()' - Kakao clicks с визуализацией. 2.ClickParams.kakao()' - Kakao clicks. 3. `ClickParams.default()' - Espresso clicks. Используются по умолчанию.

Логгеры
Kaspresso предоставляет два вида логгеров: libLogger и testLogger. libLogger - внутренний логгер Kaspresso
testLogger - логгер, который доступен разработчикам в тестах.
Последний доступен через свойство testLogger в тестовых разделах (before, after, init, transform, run) в тестовом DSL (из класса TestContext).
Кроме того, он доступен при настройке Kaspresso.Builder, если вы хотите добавить его, например, в свои пользовательские перехватчики.

Перехватчики Kaspresso на базе перехватчиков Kakao/Kautomator.
Эти перехватчики были введены для упрощения и единообразия использования перехватчиков Kakao и перехватчиков Kautomator.

Важный момент о смешении перехватчиков Kaspresso и перехватчиков Kakao/Kautomator.
Перехватчики Kaspresso не будут работать, если вы установите свои собственные перехватчики Kakao, вызвав метод Kakao.intercept в тесте, или установите свои пользовательские перехватчики Kautomator, вызвав Kautomator.intercept в тесте.
Если вы установите свои пользовательские перехватчики Kakao для конкретного экрана или KView и установите для аргумента isOverride значение true, то перехватчики Kaspresso не будут работать для конкретного экрана или KView. То же самое верно и для Kautomator, где разработчик взаимодействует с UiScreen и UiBaseView.

Перехватчики Kaspresso можно разделить на два типа:

Behavior Interceptors - перехватывают вызовы ViewInteraction, DataInteraction, WebInteraction, UiObjectInteraction, UiDeviceInteraction и выполняют свою логику.
Внимание, мы собираемся рассмотреть некоторые важные примечания о перехватчиках поведения в конце этого документа.
Watcher Interceptors - перехватывают вызовы ViewAction, ViewAssertion, Atom, WebAssertion, UiObjectAssertion, UiObjectAction, UiDeviceAssertion, UiDeviceAction и еще кое-что.
Расширим упомянутые типы перехватчиков Kaspresso:

Behavior Interceptors
viewBehaviorInterceptors - перехватывают вызовы ViewInteraction#perform и ViewInteraction#check
dataBehaviorInterceptors - перехватывают вызовы DataInteraction#check
webBehaviorInterceptors - перехватывают вызовы Web.WebInteraction<R>#perform и Web.WebInteraction<R>#check
objectBehaviorInterceptors - перехватывают вызовы UiObjectInteraction#perform и UiObjectInteraction#check
deviceBehaviorInterceptors - перехватывают вызовы UiDeviceInteraction#perform и UiDeviceInteraction#check
Watcher Interceptors
viewActionWatcherInterceptors – выполняют какие-то действия до того, как будет вызван android.support.test.espresso.ViewAction.perform
viewAssertionWatcherInterceptors – выполняют какие-то действия до того, как будет вызван android.support.test.espresso.ViewAssertion.check
atomWatcherInterceptors – выполняют какие-то действия до того, как будет вызван android.support.test.espresso.web.model.Atom.transform
webAssertionWatcherInterceptors — выполняют какие-то действия до того, как будет вызван android.support.test.espresso.web.assertion.WebAssertion.checkResult
objectWatcherInterceptors - выполняют какие-то действия до того, как будет вызван UiObjectInteraction.perform или UiObjectInteraction.check
deviceWatcherInterceptors - выполняют какие-то действия до того, как будет вызван UiDeviceInteraction.perform или UiDeviceInteraction.check
Пожалуйста, помните! Перехватчики поведения и наблюдателя работают под капотом в каждом действии (actions) и утверждении (assertions) каждого графического элемента (View) Kakao и Kautomator по умолчанию в Kaspresso.

Специальные перехватчики Kaspresso
Эти перехватчики не основаны на какой-то lib. Краткое описание:

stepWatcherInterceptors - перехватчик действий жизненного цикла Step
testRunWatcherInterceptors - перехватчик всех действий жизненного цикла Test.
Как вы заметили, эти перехватчики также являются частью Watcher Interceptors.

BuildStepReportWatcherInterceptor
Этот watcher interceptor по умолчанию включен в Kaspresso configurator для сбора информации о шагах ваших тестов для дальнейшей обработки в оркестраторе тестов.
Этот перехватчик основан на AllureReportWriter (подробнее про Allure).
Этот генератор отчетов работает с каждым TestInfo после завершения теста, преобразует информацию о шагах в информацию о шагах Allure JSON, а затем печатает JSON в LogCat в следующем формате:

I/KASPRESSO: ---------------------------------------------------------------------------
I/KASPRESSO: TEST PASSED
I/KASPRESSO: ---------------------------------------------------------------------------
I/KASPRESSO: #AllureStepsInfoJson#: [{"attachments":[],"name":"My step 1","parameters":[],"stage":"finished","start":1568790287246,"status":"passed", "steps":[],"stop":1568790288184}]
Эти журналы должны обрабатываться вашим тестовым оркестратором (например, Marathon). Если вы используете Marathon, вы должны знать, что он требует некоторых дополнительных модификаций для поддержки обработки этих журналов и в настоящий момент не работает должным образом. Но мы усердно работаем над этим.

Действия по умолчанию в разделах до/после
Иногда разработчик хочет поместить некоторые действия, повторяющиеся во всех тестах до/после, в одно место, чтобы упростить поддержку тестов.
Существуют аннотации @beforeTest/@afterTest для решения указанных задач. Но у разработчика нет доступа к BaseTestContext в этих методах. Вот почему мы ввели специальные действия по умолчанию, которые вы можете установить в конструкторе с помощью Kaspresso.Builder.
Пример реализации действий по умолчанию в Kaspresso.Builder:

open class YourTestCase : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        beforeEachTest {
            testLogger.i("beforeTestFirstAction")
        }
        afterEachTest {
            testLogger.i("afterTestFirstAction")
        }
    }
)
Полная сигнатура метода beforeEachTest:
beforeEachTest(override = true, action = {
    testLogger.i("beforeTestFirstAction")
})
afterEachTest аналогичен beforeEachTest.
Если вы установите override в false, то последнее beforeAction будет относиться к родительскому TestCase плюс текущий action. В противном случае последний beforeAction будет только текущим action. Чтобы понять, как это работает и как переопределить (или просто расширить) действие по умолчанию, пожалуйста, обратите внимание на пример.
Device
Экземпляр Device. Подробная информация находится на этой странице в разделе Вики.

AdbServer
Экземпляр AdbServer. Подробная информация находится на этой странице в разделе Вики. */