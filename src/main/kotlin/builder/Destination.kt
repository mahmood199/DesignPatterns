package builder

sealed interface Destination
@JvmInline value class EmailAddress(val value: String): Destination
@JvmInline value class PhoneNumber(val value: String): Destination

