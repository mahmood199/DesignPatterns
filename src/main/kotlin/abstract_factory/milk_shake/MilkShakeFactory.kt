package abstract_factory.milk_shake

import abstract_factory.IceBlend
import abstract_factory.IceBlendFactory
import abstract_factory.Request

class MilkShakeFactory : IceBlendFactory {

    override fun prepareTreat(request: Request): IceBlend {
        return when (request) {
            is Request.MilkShake -> MilkShake(
                creamPercentage = request.creamPercentage,
                sugar = request.sugar,
                flavour = request.flavour,
                quantityRange = request.quantityRange
            )

            else -> throw Exception("Illegal Argument. Cannot create non-milk shake product here")
        }
    }

}