package composite

class DeliveryService {

    lateinit var box: Box

    fun setupOrder(vararg box: Box) {
        CompositeBox(children = box.toMutableList())
    }

    fun getOrderPrice(): Double {
        return box.calculatePrice()
    }

}