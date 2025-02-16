package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf

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
//Для фигур с 3 и более сторонами количество углов совпадает с количеством сторон.
//Для фигур с 1 или 2 сторонами (линий) углы отсутствуют (значение углов = 0).


class AngleChecker(
//    private val angleCount: Int
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("")
    }

    override fun matchesSafely(item: Shape): Boolean {
        if (item.sideCount in 1..2) {
            return true
        }
        if (item.sideCount >= 3) {
            return true
        } else {
            return false
        }
    }
}

fun angle(): AngleChecker {
    return AngleChecker()
}

//Проверка на чётное количество сторон

class EvenSideCount() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Shape side count should be even")
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

fun negCount(): NegativeSideCount {
    return NegativeSideCount()
}

//Проверка цвета фигуры

class ColorChecker(
    private val expectedColor: Color
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Shape color should be ${expectedColor}")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == expectedColor
    }
}

fun color(expectedColor: Color): ColorChecker {
    return ColorChecker(expectedColor)
}


fun main() {


    val shape1 = Shape(6.1f, 6, Color.RED)
//    assertThat(shape1, size(5.1f,100f))
    assertThat(shape1, even())
    assertThat(shape1, negLength())
    assertThat(shape1, negCount())
    assertThat(shape1, color(Color.BLUE))

    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )

    val filteredShapes = shapes.filter { item ->
        allOf(
            size(0.1f,100f),
            even(),
            negLength(),
            negCount(),
            color(Color.BLUE)
        ).matches(item)
    }

    println(filteredShapes)
}