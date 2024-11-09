package builder

sealed interface Frequency {
    data object Immediately: Frequency
    data object Daily: Frequency
    data object Weekly: Frequency
}
