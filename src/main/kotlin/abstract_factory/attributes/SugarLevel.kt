package abstract_factory.attributes

sealed interface SugarLevel {

    data object LowSugar : SugarLevel

    data object ModerateSugar : SugarLevel

    data object HighSugar : SugarLevel

}