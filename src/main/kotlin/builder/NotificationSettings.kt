package builder

data class NotificationSettings(
    val isEnabled: Boolean = false,
    val subscriptions: List<Subscription> = listOf()
)
val emailAddress = EmailAddress(value = "Mahmood")
val phoneNumber = PhoneNumber("9876543210")

fun main() {
    createNotificationSettings(
        emailAddress = emailAddress,
        phoneNumber = phoneNumber
    )
    createNotificationSettingsV2(
        emailAddress = emailAddress,
        phoneNumber = phoneNumber
    )
}

fun createNotificationSettings(emailAddress: EmailAddress?, phoneNumber: PhoneNumber?): NotificationSettings {
    return NotificationSettings(
        isEnabled = true,
        subscriptions = buildList<Subscription> {
            if (emailAddress != null) add(
                Subscription(
                    destination = emailAddress,
                    topic = Topic.Analytics,
                    frequency = Frequency.Daily
                )
            )
            if (emailAddress != null) add(
                Subscription(
                    destination = emailAddress,
                    topic = Topic.News,
                    frequency = Frequency.Weekly
                )
            )
            if (phoneNumber != null) add(
                Subscription(
                    destination = phoneNumber,
                    topic = Topic.SecurityAlerts,
                    frequency = Frequency.Immediately
                )
            )
        }
    )
}