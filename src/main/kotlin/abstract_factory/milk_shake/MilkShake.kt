package abstract_factory.milk_shake

import abstract_factory.attributes.Flavour
import abstract_factory.IceBlend
import abstract_factory.attributes.QuantityRange
import abstract_factory.attributes.SugarLevel

class MilkShake(
    override val creamPercentage: Int,
    override val sugar: SugarLevel,
    override val flavour: Flavour,
    private val quantityRange: QuantityRange
) : IceBlend {

    override fun serve() {
        println(
            "Serve milk shake of quantity: $quantityRange with flavour: $flavour " +
                    "and sugar level: $sugar " +
                    "and creamPercentage: ${creamPercentage / 100f}"
        )
    }

}