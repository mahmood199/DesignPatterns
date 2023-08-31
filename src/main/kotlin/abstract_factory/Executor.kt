package abstract_factory

import abstract_factory.attributes.Flavour
import abstract_factory.attributes.SugarLevel
import abstract_factory.ice_cream.IceCreamFactory

fun main() {
    val iceCreamFactory = IceCreamFactory()
    val request: Request = Request.IceCream(
        creamPercentage = 75,
        sugar = SugarLevel.ModerateSugar,
        flavour = Flavour.BlackForest,
        scoops = 3
    )
    val treat = iceCreamFactory.prepareTreat(request)
    treat.serve()
}