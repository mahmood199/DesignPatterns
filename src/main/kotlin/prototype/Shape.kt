package prototype

data class Shape(
    var xCoordinate: Int = 0,
    var yCoordinate: Int = 0,
    var color: String = ""
) : Cloneable {

    fun cloneTo(): Shape? {
        return try {
            val copy = super.clone() as Shape
            copy.xCoordinate = this.xCoordinate
            copy.yCoordinate = this.yCoordinate
            copy.color = this.color
            return copy
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
            null
        }
    }
}
