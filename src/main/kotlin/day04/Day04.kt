package day04

import util.asResource

fun validA(input: String): Boolean {
    val parts = input.split(" ")

    return parts.size == parts.distinct().size
}

fun validB(input: String): Boolean {
    val parts = input.split(" ")
            .map { it -> it.toList().sorted().joinToString("") }

    return parts.size == parts.distinct().size
}

fun day4A(input: String) = input.trim().lines().filter { it -> validA(it) }.count()
fun day4B(input: String) = input.trim().lines().filter { it -> validB(it) }.count()

fun main(args: Array<String>) {
    check(validA("aa bb cc dd ee"))
    check(!validA("aa bb cc dd aa"))
    check(validA("aa bb cc dd aaa"))

    check(validB("abcde fghij"))
    check(!validB("abcde xyz ecdab"))
    check(validB("a ab abc abd abf abj"))
    check(validB("iiii oiii ooii oooi oooo"))
    check(!validB("oiii ioii iioi iiio"))

    "/inputs/day04.txt".asResource {
        println("A: ${day4A(it)}")
        println("B: ${day4B(it)}")
    }
}
