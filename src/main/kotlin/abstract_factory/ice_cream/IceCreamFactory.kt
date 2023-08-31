package abstract_factory.ice_cream

import abstract_factory.IceBlend
import abstract_factory.IceBlendFactory
import abstract_factory.Request

class IceCreamFactory : IceBlendFactory {

    override fun prepareTreat(request: Request): IceBlend {
        return when (request) {
            is Request.IceCream -> IceCream(
                creamPercentage = request.creamPercentage,
                sugar = request.sugar,
                flavour = request.flavour,
                scoops = request.scoops
            )

            else -> throw Exception("Illegal Argument. Cannot create non-ice-cream product here")
        }
    }

}