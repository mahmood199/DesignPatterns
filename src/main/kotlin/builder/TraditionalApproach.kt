package builder

class NotificationSettingsBuilder : INotificationSettingsBuilder {

    private val subscriptions = mutableListOf<Subscription>()

    override var enabled: Boolean = false

    fun send(topicToDestination: Pair<Topic, Destination>, frequency: Frequency) {
        val (topic, destination) = topicToDestination
        subscriptions.add(element = Subscription(destination = destination, topic = topic, frequency = frequency))
    }

    override fun addSubscription(destination: Destination, topic: Topic, frequency: Frequency) {
        subscriptions.add(element = Subscription(destination = destination, topic = topic, frequency = frequency))
    }

    override fun build(): NotificationSettings {
        return NotificationSettings(isEnabled = enabled, subscriptions = subscriptions)
    }

}

interface INotificationSettingsBuilder {

    var enabled: Boolean

    fun addSubscription(destination: Destination, topic: Topic, frequency: Frequency)

    fun build(): NotificationSettings

}


fun createNotificationSettingsV2(emailAddress: EmailAddress?, phoneNumber: PhoneNumber?): NotificationSettings {
    val builder = NotificationSettingsBuilder()
    builder.enabled = true
    if (emailAddress != null) builder.addSubscription(
        destination = emailAddress,
        topic = Topic.Analytics,
        frequency = Frequency.Daily
    )
    if (emailAddress != null) builder.addSubscription(
        destination = emailAddress,
        topic = Topic.News,
        frequency = Frequency.Weekly
    )
    if (phoneNumber != null) builder.addSubscription(
        destination = phoneNumber,
        topic = Topic.SecurityAlerts,
        frequency = Frequency.Immediately
    )
    return builder.build()
}