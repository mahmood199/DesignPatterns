package factory

class AnonymousFactory : FigureFactory {

    override fun createFigure(type: FigureFactory.Type) = object : Figure {

        override fun createManipulator() = object : FigureManipulator<Figure> {
            override fun drag() {
                println("AnonymousFigure Dragging")
            }

            override fun resize(scale: Float) {
                println("AnonymousFigure Resizing")
            }
        }
    }
}