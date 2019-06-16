package com.ourisaban.csv.parser

import java.time.LocalTime

class Column(val header: Any, val data: ArrayList<String>) {
    fun type() = ColumnTypeIdentifier.identifyColumnType(this.data[0])

    fun min(): Any? = when {
        this.type() == ColumnTypeIdentifier.EColumnType.Double -> this.data.map { it.toDouble() }.min()
        this.type() == ColumnTypeIdentifier.EColumnType.Date -> this.data.map { LocalTime.parse(it) }.min()
        else -> this.data.min()
    }

    fun max(): Any? = when {
        this.type() == ColumnTypeIdentifier.EColumnType.Double -> this.data.map { it.toDouble() }.max()
        this.type() == ColumnTypeIdentifier.EColumnType.Date -> this.data.map { LocalTime.parse(it) }.max()
        else -> this.data.max()
    }

    override fun toString(): String {
        return "Column(header=$header, data=$data)"
    }
}