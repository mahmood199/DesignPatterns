import kotlinx.coroutines.*
import kotlin.coroutines.*
import kotlin.system.measureTimeMillis


val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)


suspend fun work(i: Int)= withContext(Dispatchers.IO) {
    Thread.sleep(1000)
    println("Work $i done")
}

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            for (i in 1..2) {
                launch {
                    work(i)
                }
            }
        }
    }
    println("Done in $time ms")
}