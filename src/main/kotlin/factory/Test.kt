package factory

class FakeFactory : FigureFactory {
    override fun createFigure(type: FigureFactory.Type): Figure {
        return FakeFigure()
    }
}

class FakeFigure : Figure {
    override fun createManipulator(): FigureManipulator<out Figure> {
        return FakeFigureManipulator()
    }
}

class FakeFigureManipulator : FigureManipulator<FakeFigure> {
    override fun drag() = println("FakeFigure dragging")
    override fun resize(scale: Float) = println("FakeFigure resizing")
}

val fakeFigure = FakeFactory()
    .createFigure(FigureFactory.Type.Circle)