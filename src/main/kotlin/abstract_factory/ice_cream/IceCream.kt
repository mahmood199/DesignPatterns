package abstract_factory.ice_cream

import abstract_factory.attributes.Flavour
import abstract_factory.IceBlend
import abstract_factory.attributes.SugarLevel

class IceCream(
    override val creamPercentage: Int,
    override val sugar: SugarLevel,
    override val flavour: Flavour,
    private val scoops: Int
) : IceBlend {

    override fun serve() {
        println(
            "Serve ice-cream of $scoops scoops with flavour: $flavour " +
                    "and sugar level: $sugar " +
                    "and creamPercentage: ${creamPercentage / 100f}"
        )
    }

}