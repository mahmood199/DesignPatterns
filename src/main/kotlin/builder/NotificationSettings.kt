package builder

data class NotificationSettings(
    val isEnabled: Boolean,
    val subscriptions: List<Subscription>
)

fun main() {
    createNotificationSettings(
        emailAddress = EmailAddress(value = "Mahmood"),
        phoneNumber = PhoneNumber("9876543210")
    )
    createNotificationSettingsV2(
        emailAddress = EmailAddress(value = "Mahmood"),
        phoneNumber = PhoneNumber("9876543210")
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