package me.femrek.pub_dev_version_fetcher.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object AppDateTimeUtil {
    /**
     * Converts a date string from ISO-8601 UTC format (e.g., "2026-03-17T10:45:57.622079Z") 
     * to "dd/MM/yyyy HH:mm" format in the system default timezone.
     * 
     * @param dateStr The date string in ISO-8601 UTC format.
     * @return The date string in "dd/MM/yyyy HH:mm" format,
     *         or the original string if parsing fails.
     */
    fun convertDateFormat(dateStr: String): String {
        return try {
            val instant = Instant.parse(dateStr)
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
                .withZone(ZoneId.systemDefault())
            formatter.format(instant)
        } catch (e: Exception) {
            println("Error parsing date: $dateStr. Returning original string.")
            e.printStackTrace()
            dateStr // Return original string on failure
        }
    }
}