package dispatchers

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

var i = 0

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main(): Unit = coroutineScope {
    val dispatcher = Dispatchers.Default.limitedParallelism(10)

    val launch = launch(dispatcher) {
        repeat(5) {
            launch {
                Thread.sleep(1000)
                yield()
            }
        }
    }

    val time = measureTimeMillis { launch.join() }
    println("Took $time") // Took 5006
}