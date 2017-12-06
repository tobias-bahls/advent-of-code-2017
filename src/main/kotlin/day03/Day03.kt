package day03

data class Point(val x: Int, val y: Int)
enum class Dir { UP, RIGHT, DOWN, LEFT }

fun switchDirection(dir: Dir) = when (dir) {
    Dir.UP -> Dir.LEFT
    Dir.RIGHT -> Dir.UP
    Dir.DOWN -> Dir.RIGHT
    Dir.LEFT -> Dir.DOWN
}

fun day3A(input: Int): Int {
    var location = Point(0, 0)
    var direction = Dir.RIGHT
    var number = 1
    var sideLength = 1

    while (true) {
        1.until(sideLength + 1).forEach { j ->
            if (number == input) {
                return Math.abs(location.x) + Math.abs(location.y)
            }

            location = when (direction) {
                Dir.UP -> Point(location.x, location.y + 1)
                Dir.RIGHT -> Point(location.x + 1, location.y)
                Dir.DOWN -> Point(location.x, location.y - 1)
                Dir.LEFT -> Point(location.x - 1, location.y)
            }

            number++
        }

        direction = switchDirection(direction)
        if (direction == Dir.RIGHT || direction == Dir.LEFT) sideLength += 1
    }
}

fun day3B(input: Int): Int {
    var location = Point(0, 0)
    var direction = Dir.RIGHT
    var number = 1
    var sideLength = 1
    val memory = hashMapOf(Pair(Point(0, 0), 1))

    while (true) {
        1.until(sideLength + 1).forEach { j ->
            if (number >= input) {
                return number
            }

            location = when (direction) {
                Dir.UP -> Point(location.x, location.y + 1)
                Dir.RIGHT -> Point(location.x + 1, location.y)
                Dir.DOWN -> Point(location.x, location.y - 1)
                Dir.LEFT -> Point(location.x - 1, location.y)
            }

            number = listOf(
                    Point(location.x+1, location.y+1),
                    Point(location.x+1, location.y),
                    Point(location.x+1, location.y-1),
                    Point(location.x, location.y+1),
                    Point(location.x, location.y-1),
                    Point(location.x-1, location.y+1),
                    Point(location.x-1, location.y),
                    Point(location.x-1, location.y-1)
            ).map { memory[it] ?: 0 }.sum()

            memory[location] = number
        }

        direction = switchDirection(direction)
        if (direction == Dir.RIGHT || direction == Dir.LEFT) sideLength += 1
    }
}

fun main(args: Array<String>) {
    check(day3A(1) == 0)
    check(day3A(12) == 3)
    check(day3A(23) == 2)
    check(day3A(1024) == 31)

    println(day3A(312051))
    println(day3B(312051))
}
