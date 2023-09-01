package prototype

fun main() {
    val original: Shape = Shape().apply {
        xCoordinate = 10
        yCoordinate = 3
        color = "red"
    }

    val copy = original.cloneTo()?.apply {
        yCoordinate = 80
        color = "blue"
    }

    val copy2 = original.copy(xCoordinate = 21)

    println(copy!!.xCoordinate)

    println(copy2.xCoordinate)
}