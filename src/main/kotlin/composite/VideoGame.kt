package composite

class VideoGame(
    private val vTitle: String,
    private val vPrice: Double
) : Product(title = vTitle, price = vPrice) {

    override fun calculatePrice(): Double {
        return vPrice
    }

}