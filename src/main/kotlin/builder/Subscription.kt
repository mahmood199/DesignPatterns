package builder

data class Subscription(
    val destination: Destination,
    val topic: Topic,
    val frequency: Frequency
) {

}
