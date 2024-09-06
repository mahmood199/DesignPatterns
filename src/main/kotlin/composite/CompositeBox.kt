package composite

class CompositeBox(
    private val children: MutableList<Box>
): Box {

    fun addBox(box: Box) {
        children.add(box)
    }

    fun addBoxes(boxes: List<Box>) {
        children.addAll(boxes)
    }

    fun removeBox(box: Box) {
        children.remove(box)
    }

    override fun calculatePrice(): Double {
        return children.sumOf {
            it.calculatePrice()
        }
    }


}