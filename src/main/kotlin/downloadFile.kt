import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

suspend fun printName() {
    println(coroutineContext[CoroutineName]?.name)
}

fun main() = runBlocking(CoroutineName("Outer")) {
    printName() // Outer
    launch(CoroutineName("Inner")) {
        printName() // Inner
    }

    withContext(EmptyCoroutineContext) {

    }

    delay(10)
    printName() // Outer
}