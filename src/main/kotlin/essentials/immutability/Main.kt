package essentials.immutability

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.properties.Delegates
import kotlin.time.measureTime


var name: String = "Marcin"
var surname: String = "Moskała"
val fullName
    get() = "$name $surname"

fun calculate(): Int {
    print("Calculating... ")
    return 42
}

//val fizz = calculate() // Calculating...
val buzz
    get() = calculate()

val name1: String? = "Márton"
val surname1: String = "Braun"

val fullName1: String?
    get() = name1?.let { "$it $surname1" }

val fullName2: String? = name1?.let { "$it $surname1" }


fun main() = runBlocking {
/*
    Part1
    firstTry()
    secondTryWithCoroutines()
    thirdTryWithLocks()
*/


    /*
        Part2

        println(fullName) // Marcin Moskała
        name = "Maja"
        println(fullName) //
    */


    /*
        Part3
        println(fizz) // Calculating... 42
        println(fizz) // 42
        println(fizz) // 42
        println(fizz) // 42
        println(buzz) // Calculating... 42
        println(buzz) // Calculating... 42
        println(buzz) // Calculating... 42
    */

    /*      Part4
        if (fullName1 != null) {
            println(fullName1.length) // ERROR: Smart cast impossible because this field has custom getter
        }

        if (fullName2 != null) {
            println(fullName2.length) // Márton Braun
        }*/

    /*    val list = listOf(1, 2, 3)

    // DON’T DO THIS!
        if (list is MutableList) {
            list.add(4)
        }*/


//    fourthConcept()

    fifthConcept()

}

data class FullNameX(var name: String, val lastName: String)

fun fourthConcept() {
    val names = mutableListOf<FullNameX>()
    val person = FullNameX("AAA", "AAA")
    names.add(person)
    names.add(FullNameX("Jordan", "Hansen"))
    names.add(FullNameX("David", "Blanc"))

    println(names) // [AAA AAA, David Blanc, Jordan Hansen]
    println(person in names) // true

    person.name = "ZZZ"
    println(names) // [ZZZ AAA, David Blanc, Jordan Hansen]
    println(person in names) // false, because person is at incorrect position
}

fun fifthConcept() {
    var names by Delegates.observable(listOf<String>())
    { _, old, new ->
        println("Names changed from $old to $new")
    }
    names += "Fabio"
    names += "Billi"
}

fun firstTry() {
    val timeToExecute = measureTime {
        var num = 0
        for (i in 1..1000) {
            thread {
                Thread.sleep(10)
                num += 1
            }
        }
        Thread.sleep(5000)
        println(num)
    }
    println("Time to execute1 $timeToExecute")
}

suspend fun secondTryWithCoroutines() {
    val timeToExecute = measureTime {
        var num = 0
        coroutineScope {
            for (i in 1..1000) {
                launch {
                    delay(10)
                    num += 1
                }
            }
        }
        println(num) // Every time a different number, for example 991}
    }
    println("Time to execute2 $timeToExecute")
}

fun thirdTryWithLocks() {
    val timeToExecute = measureTime {
        val lock = Any()
        var num = 0
        for (i in 1..1000) {
            thread {
                Thread.sleep(10)
                synchronized(lock) {
                    num += 1
                }
            }
        }
        println(num) // Every time a different number, for example 991}
    }
    Thread.sleep(1000)
    println("Time to execute3 $timeToExecute")
}
