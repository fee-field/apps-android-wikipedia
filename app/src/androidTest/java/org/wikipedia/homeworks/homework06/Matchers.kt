package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeMatcher

enum class Color {
    RED, BLUE, GREEN, YELLOW, BLACK, WHITE
}

data class Shape(
    val sideLength: Float,
    val sideCount: Int,
    val color: Color
)

// Проверка длины стороны в заданном диапазоне (например, от 0.1 до 100.0).

class SizeValidationMatcher(
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the range should be: from $min to $max")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength in min..max
    }
}

fun size(min: Float, max: Float): SizeValidationMatcher {
    return SizeValidationMatcher(min, max)
}

//Проверка количества углов

//Проверка на чётное количество сторон

class EvenSideCount() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("the side count is even")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideCount % 2 == 0
    }
}

fun even(): EvenSideCount {
    return EvenSideCount()
}

//Проверка на наличие отрицательной длины стороны (недопустимо).

class NegativeLengthMatcher(
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Side length should be positive")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength > 0
    }

}

fun negLength(): NegativeLengthMatcher {
    return NegativeLengthMatcher()
}

//Проверка на наличие отрицательного количества сторон (недопустимо)

class NegativeSideCount() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Side count should be positive")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideCount > 0
    }
}

fun negCount() : NegativeSideCount {
    return NegativeSideCount()
}


fun main() {
    val shape1 = Shape(6.1f, -6, Color.RED)
//    assertThat(shape1, size(5.1f,100f))
    assertThat(shape1, even())
    assertThat(shape1, negLength())
    assertThat(shape1, negCount())
}