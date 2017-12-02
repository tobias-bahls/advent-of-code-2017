package day02

import com.google.common.collect.Lists
import util.asResource

fun parse(input: String) = input.lines()
        .map { it.split(" ", "\t").filter { !it.isEmpty() }.map { it.trim().toInt() } }
        .filter { !it.isEmpty() }

fun day2A(input: String) =
        parse(input)
                .map { it.max()!! - it.min()!! }
                .foldRight(0, { i, acc -> acc + i })

fun day2B(input: String) =
        parse(input)
                .map {
                    Lists.cartesianProduct(it, it).mapNotNull {
                        when {
                            it[0] == it[1] -> null
                            it[0] % it[1] == 0 -> it[0] / it[1]
                            it[1] % it[0] == 0 -> it[1] / it[0]
                            else -> null
                        }
                    }.first()
                }
                .foldRight(0, { i, acc -> acc + i })

fun main(args: Array<String>) {
    check(day2A("5 1 9 5\n" +
    "7 5 3\n" +
    "2 4 6 8") == 18)

    check(day2B("5 9 2 8\n" +
            "9 4 7 3\n" +
            "3 8 6 5\n") == 9)

    "/inputs/day02.txt".asResource {
        println(day2A(it))
        println(day2B(it))
    }
}
