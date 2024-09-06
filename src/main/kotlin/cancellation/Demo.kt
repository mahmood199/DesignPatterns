package cancellation

import kotlinx.coroutines.*

val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("We've gotta nigga exception + ${throwable.message}")
    throwable.printStackTrace()
}

fun main() {
//    try1()
//    try2()
//    try3()
    try4()
}

fun try4() {
    val rootScope = CoroutineScope(Job()) + coroutineExceptionHandler
    println("Some message before work delay")
    rootScope.launch(coroutineExceptionHandler) {
        supervisorScope {
            launch {
                delay(300)
                throw Exception("Some exception")
            }
            launch {
                delay(400)
                println("Some message after delay")
            }
        }.join()
    }
    Thread.sleep(1000)
}

fun try3() = runBlocking {
    val rootScope = CoroutineScope(Job()) + coroutineExceptionHandler
    val job = rootScope.launch {
        try {
            println("Starting network request")
            delay(1200)
        } catch (e: Exception) {
            if (e is CancellationException) {
                println("Caught cancel exception")
            } else {
                println("Caught exception")
            }
            e.printStackTrace()
        }
    }

    delay(200)
    job.cancelAndJoin()
    println("Coroutine running")

}

fun try2() {
    val rootScope = CoroutineScope(Job()) + coroutineExceptionHandler
    rootScope.launch {
        val result1 = async {
            delay(200)
            throw Exception("Flaying exception")
            "1"
        }

        val result2 = async {
            delay(3000)
            "Newing"
        }

        println(awaitAll(result1, result2))
    }
    Thread.sleep(5000)
}

fun try1() {
    val rootScope = CoroutineScope(Job())

    rootScope.launch {
        try {
//            coroutineScope {
//
//            }
            //if we wrap the below launch call within coroutineScope then it willtr-trhow this uncaught exception and
            // We will have our log of catch printed
            launch {
                suspendFunctionThatThrowsException()
            }
        } catch (e: Exception) {
            println("We've gotta nigga exception in launch")
            e.printStackTrace()
        }
    }
    Thread.sleep(1234)
}

// Child coroutine propagate exception towards parents
// Whenever exception is not handled directly in the coroutine, it will be propagated upper in the job hierarchy.
// Installing CEH to child coroutines won't have any effect. It'll throw exception as it is.
// GOTCHA ----> CEH must be installed @ parent

// Launch propagates the exception. Async does not. Until we call await on async.
//

/**
 *      CoroutineExceptionHandler                           vs  try catch -->
 * 1.   Global catch all                                    |
 * 2.   Completed exceptionally                             |   doesn't complete exceptionally
 * 3.   No Recovery.. cant be reused for new coroutines     |
 *  while using try-catch --> keep the concept of structured concurrency in mind while handling exception
 *
 *
 * Calling cancel inside of launch and async does nothing. Refer CodingWithMitch video.
 * we need to call it on the job or deferred type object.
 */

/**
 * PArent coroutine doesn't get cancelled when any of the child throws CancellationException.
 * In all other exceptions the parent and its child coroutines gets cancelled if we dont use super Visor scope
 */

suspend fun suspendFunctionThatThrowsException() {
    delay(100)
    throw Exception("Random exception")
}