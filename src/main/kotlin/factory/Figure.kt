package factory


interface Figure {
    fun createManipulator(): FigureManipulator<out Figure>
}

class Circle : Figure {
    override fun createManipulator() = CircleManipulator(this)
}

class Square : Figure {
    override fun createManipulator() = SquareManipulator(this)
}

class Line : Figure {
    override fun createManipulator() = LineManipulator(this)
}