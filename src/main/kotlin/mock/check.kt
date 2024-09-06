package mock

import kotlinx.coroutines.*


// Either make main function as suspend or use runBlocking
// But CoroutineScope extension func like launch and async will not be callable. if we use suspend.

// coroutineScope --> all child jobs will be cancelled.
// superVisorScope --> only single child will be cancelled
// Create StopWatch and timer in coroutine and flow.
// How to create timer with coroutine. Upar upar se dekh lena



// Delay internally uses Handler.postDelay.
// Timer stops in doze mode.

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            println("Coroutine started")
            delay(200)
            println("Coroutine finished")
        } finally {
            job.cancel()
            delay(123)
            println("Finally")
            withContext(NonCancellable) {
                launch {
                    println("Children executed")
                }
                delay(1000L)
                println("Cleanup done")
            }
        }
    }
    delay(100)
    job.cancelAndJoin()
    println("Done")
}

// Clear all the requirements before starting off with coding.
// What can we use for Google?
// Check migration docs for auto migration
// Threads upar upar se...See the apis. Executors and all.
//


suspend fun scanning() {
    delay(10000)
    println("dsafsg")
}


// Cancellation
//