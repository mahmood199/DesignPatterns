package builder

fun createNotificationSettingsV3(
    emailAddress: EmailAddress?,
    phoneNumber: PhoneNumber?
): NotificationSettings {
    val notificationSettings = notificationSettings {
        enabled = false
        send(
            topicToDestination = (Topic.Analytics to emailAddress) as Pair<Topic, Destination>,
            frequency = Frequency.Daily
        )
        send(
            topicToDestination = (Topic.News to emailAddress) as Pair<Topic, Destination>,
            frequency = Frequency.Weekly
        )
        send(
            topicToDestination = (Topic.SecurityAlerts to phoneNumber) as Pair<Topic, Destination>,
            frequency = Frequency.Immediately
        )
    }
    return notificationSettings
}

fun notificationSettings(block: NotificationSettingsBuilder.() -> Unit) =
    NotificationSettingsBuilder().apply { block() }.build()


fun main() {
    createNotificationSettingsV3(
        emailAddress = emailAddress,
        phoneNumber = phoneNumber
    )
}