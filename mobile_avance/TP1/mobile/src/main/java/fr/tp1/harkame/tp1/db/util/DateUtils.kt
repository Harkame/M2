package fr.tp1.harkame.tp1

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateUtils {

    const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

    @JvmStatic
    fun localDateTimeToString(localDateTime: LocalDateTime): String {
        val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)

        return localDateTime.format(formatter)
    }

    @JvmStatic
    fun stringToLocalDateTime(eventDate: String): LocalDateTime {
        val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)

        return LocalDateTime.parse(eventDate, formatter)
    }
}