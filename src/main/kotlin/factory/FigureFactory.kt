package factory

interface FigureFactory {
    enum class Type { Circle, Square, Line, Undefined }

    fun createFigure(type: Type): Figure
}

// Common Factory implementation where it creates instances for provided enum type
class ByTypeFactory : FigureFactory {

    override fun createFigure(type: FigureFactory.Type): Figure =
    when (type) { // compilation error will happen if not all enum types are handled
            FigureFactory.Type.Circle -> Circle()
            FigureFactory.Type.Square -> Square()
            FigureFactory.Type.Line -> Line()
            // `Undefined` is not handled explicitly but it will fall in the `else`
            else -> throw Exception("unknown figure, don't know how to create it")
        }
}


class UndefinedFigureFactory : FigureFactory {
    // whatever the `type` parameter is, the same object will be returned
    override fun createFigure(type: FigureFactory.Type) = object: Figure {
        // with the same manipulator
        override fun createManipulator() = object: FigureManipulator<Figure> {
            override fun drag() = println("UndefinedFigure dragging")
            override fun resize(scale: Float) = println("UndefinedFigure resizing")
        }
    }
}