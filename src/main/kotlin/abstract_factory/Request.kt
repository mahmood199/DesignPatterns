package abstract_factory

import abstract_factory.attributes.Flavour
import abstract_factory.attributes.QuantityRange
import abstract_factory.attributes.SugarLevel

sealed interface Request {

    data class IceCream(
        val creamPercentage: Int,
        val sugar: SugarLevel,
        val flavour: Flavour,
        val scoops: Int,
    ) : Request

    data class MilkShake(
        val creamPercentage: Int,
        val sugar: SugarLevel,
        val flavour: Flavour,
        val quantityRange: QuantityRange,
    ) : Request

}