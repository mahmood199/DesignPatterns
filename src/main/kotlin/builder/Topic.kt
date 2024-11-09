package builder

sealed interface Topic {
    data object News: Topic
    data object Analytics: Topic
    data object SecurityAlerts: Topic
}
