package org.wikipedia.homeworks.homework020

import NamedSteps
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework019.Steps

private val stepContextCache = mutableMapOf<TestContext<*>, NamedSteps>()
val TestContext<*>.steps: NamedSteps
    get() = stepContextCache.getOrPut(this) { NamedSteps(this) }