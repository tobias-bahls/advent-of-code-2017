package day01

import util.asResource

private fun solve(numbers: List<Int>, step: Int) = numbers
        .mapIndexed { idx, _ -> listOf(numbers[idx], numbers[(idx + step) % numbers.size]) }
        .filter { (e1, e2) -> e1 == e2 }
        .map { (e, _) -> e }
        .fold(0, { acc, i -> acc + i })

fun day1A(input: String) = solve(input.trim().map { it -> it.toString().toInt() }, 1)
fun day1B(input: String) = solve(input.trim().map { it -> it.toString().toInt() }, input.length / 2)

fun main(args: Array<String>) {
    check(day1A("1122") == 3)
    check(day1A("1111") == 4)
    check(day1A("1234") == 0)
    check(day1A("91212129") == 9)

    check(day1B("1212") == 6)
    check(day1B("1221") == 0)
    check(day1B("123425") == 4)
    check(day1B("123123") == 12)
    check(day1B("12131415") == 4)

    "/inputs/day01.txt".asResource {
        println("A: ${day1A(it)}")
        println("B: ${day1B(it)}")
    }
}
