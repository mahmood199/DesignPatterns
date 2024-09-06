import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

suspend fun main(): Unit = runBlocking {
    val job = Job()
    launch(job) { // the new job replaces one from parent
        delay(1000)
        println("Text 1")
    }
    launch(job) { // the new job replaces one from parent
        delay(2000)
        println("Text 2")
    }
    job.complete()
    job.completeExceptionally(Exception("HHEHEHEH"))
    job.join()
//    job.children.forEach { it.join() }
    println("Will be printed")
}

val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
    throwable.printStackTrace()
}

suspend fun check()= coroutineScope {
    4
    ""
}

suspend fun check2()= supervisorScope {
    4
    ""
}

suspend fun getSongsFromAPI(page: Int): List<String> {
    // do API call
    return listOf("")
}
const val totalNumberOfPages = 10

suspend fun getAllSongs() = coroutineScope{
    // scope can be any scope you'd want a typical case would be viewModelScope
    launch {
        val allNews = (0..<totalNumberOfPages)
            .map { page -> async { getSongsFromAPI(page) } }
            .awaitAll()
    }
}