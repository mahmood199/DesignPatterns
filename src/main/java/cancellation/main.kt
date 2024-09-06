package cancellation

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.System.currentTimeMillis

fun main() {
    runBlocking {
        supervisorScope {
            val loader = ImageLoader()
            val request = Request(imageUrl = "https://1.image.link", ImageView())
            val request2 = Request(imageUrl = "https://2.image.link", ImageView())
            val request3 = Request(imageUrl = "https://3.image.link", ImageView())
            val request4 = Request(imageUrl = "https://4.image.link", ImageView())

            loader.load(this, request)
            loader.load(this, request2)
            loader.load(this, request3)
            loader.load(this, request4)
            launch {
                delay(700)
                loader.cancelRequest(request3)
            }
        }
    }
}

class ImageLoader {

    private val requests = hashMapOf<Request, Job>()


    fun load(coroutineScope: CoroutineScope, request: Request) {
        requests[request] = coroutineScope.launch(
            CoroutineExceptionHandler { coroutineContext, throwable -> println(throwable) }
        ) {
            println("Got load request: $request")
            val bitmapStream = withContext(Dispatchers.IO) { downloadBitmap(request) }
            val bitmap = withContext(Dispatchers.Default) { decodeBitmap(bitmapStream) }
            withContext(Dispatchers.Unconfined) { request.imageView.setImageBitmap(bitmap) }
        }
    }

    suspend fun downloadBitmap(request: Request): BitmapStream {
        println("Download started at ${currentTimeMillis()} for $request...")
        delay((500..2000).random().toLong())
        if ((1..5).random() < 3) {
            throw IOException("Download failed for $request")
        }
        println("Download successful for $request")
        return BitmapStream(request, byteArrayOf())
    }

    suspend fun decodeBitmap(bitmapStream: BitmapStream): Bitmap {
        println("Decode started for $bitmapStream...")
        delay((100..200).random().toLong())
        println("Decode finished for $bitmapStream")
        return Bitmap(bitmapStream)
    }

    fun cancelRequest(request: Request) {
        requests[request]?.cancel()
        requests.remove(request)
        println("Cancelled $request")
    }
}

data class Request(val imageUrl: String, val imageView: ImageView)

data class BitmapStream(private val request: Request, private val bytes: ByteArray)

data class Bitmap(private val stream: BitmapStream)

class ImageView {
    private var bitmap: Bitmap? = null

    fun setImageBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
        println("Bitmap $bitmap set at ${currentTimeMillis()} for ImageView $this")
    }
}
