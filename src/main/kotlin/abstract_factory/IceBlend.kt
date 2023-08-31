package abstract_factory

import abstract_factory.attributes.Flavour
import abstract_factory.attributes.SugarLevel

interface IceBlend {

    val creamPercentage: Int

    val sugar: SugarLevel

    val flavour: Flavour

    fun serve()

}