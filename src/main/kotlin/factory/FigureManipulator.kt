package factory

interface FigureManipulator<T : Figure> {
    fun drag()
    fun resize(scale: Float)
}

// constructor parameter type must be the one declared in FigureManipulator
class CircleManipulator<T>(private val figure: T) : FigureManipulator<Circle> {
    override fun drag() = println("CircleManipulator is manipulating circle $figure")
    override fun resize(scale: Float) = println("CircleManipulator is resizing circle $figure")
}

class SquareManipulator<T>(private val figure: T) : FigureManipulator<Square> {
    override fun drag() = println("SquareManipulator is manipulating square $figure")
    override fun resize(scale: Float) = println("SquareManipulator is resizing square $figure")
}

class LineManipulator<T>(private val figure: T) : FigureManipulator<Line> {
    override fun drag() = println("LineManipulator is manipulating line $figure")
    override fun resize(scale: Float) = println("LineManipulator is resizing line $figure")
}