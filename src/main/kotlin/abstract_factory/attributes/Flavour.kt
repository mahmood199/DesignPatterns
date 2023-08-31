package abstract_factory.attributes

sealed interface Flavour {

    data object Chocolate : Flavour

    data object Strawberry : Flavour

    data object Oreo : Flavour

    data object BlackForest : Flavour

}