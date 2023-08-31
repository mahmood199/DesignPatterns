package abstract_factory.attributes

sealed interface QuantityRange {

    data object Regular: QuantityRange

    data object Medium: QuantityRange

    data object Large: QuantityRange

}