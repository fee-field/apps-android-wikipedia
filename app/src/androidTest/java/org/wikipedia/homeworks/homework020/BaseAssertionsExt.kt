//package org.wikipedia.homeworks.homework020
//
//import io.github.kakaocup.kakao.common.assertions.BaseAssertions
//
//
//val namesAs = mutableMapOf<BaseAssertions, String>()
//
//fun <T : BaseAssertions> T.setName1(name: String): T {
//    namesAs[this] = name
//    return this
//}
//fun BaseAssertions.getName1() : String? {
//    return namesAs[this] ?: throw RuntimeException ("set name")
//}
