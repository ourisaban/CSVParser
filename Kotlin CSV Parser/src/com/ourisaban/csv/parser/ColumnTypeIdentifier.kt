package com.ourisaban.csv.parser

import java.time.LocalTime
import java.time.format.DateTimeParseException

/**
 * @author Ouri Saban
 *
 * This object is a format helper in order to detect the real type of the String sent.
 */

object ColumnTypeIdentifier {
    enum class EColumnType {
        Date,
        Double,
        String
    }

    fun identifyColumnType(columnItem: String): EColumnType {
        if (columnItem.doubleOrString() is Double)
            return ColumnTypeIdentifier.EColumnType.Double
        return dateOrString(columnItem)
    }

    fun String.doubleOrString() = toDoubleOrNull() ?: this

    fun dateOrString(sequence: String): EColumnType {
        try {
            LocalTime.parse(sequence)
        } catch (e: DateTimeParseException) {
            return ColumnTypeIdentifier.EColumnType.String
        }
        return ColumnTypeIdentifier.EColumnType.Date
    }
}
