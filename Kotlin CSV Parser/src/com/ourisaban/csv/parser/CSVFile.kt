package com.ourisaban.csv.parser

import java.io.*
import java.nio.file.Paths

/**
 * @author Ouri Saban
 *
 * This class import and build the CSV File object we will use for the library
 *
 * @constructor
 * the primary constructor of this class will stay private in order to control the different entry point of the class from secondary constructor
 * multiple secondary constructors that allow to create a CSVFile Class from different object's origin
 */

class CSVFile private constructor() {
    private lateinit var fileReader: BufferedReader
    //todo: define all constructor that define the entries for getting an existing file
     constructor(fileName: String) : this() {
        try {
            fileReader = BufferedReader(FileReader(Paths.get(fileName).toAbsolutePath().toString()))
        } catch (ex: FileNotFoundException) {
            throw CSVFileException(ex.message, ex.cause)
        }
    }
    constructor(file: File) : this() {
        if (file.exists())
            this.fileReader = file.bufferedReader()
        else
            throw CSVFileException("file doesn't exist", Throwable())
    }
    constructor(inputStream: InputStream) : this() {
        this.fileReader = inputStream.bufferedReader()
    }

    fun compile(isHeader: Boolean, delimiter: Char): CSVDataFile {
        return CSVDataFile(fileReader, isHeader, delimiter)
    }
}

fun main(array: Array<String>) {
    val file = CSVFile("test.csv")
    val csvDataFile: CSVDataFile = file.compile(true, ',')
    println(csvDataFile.getNbColumn())
    val column: Column = csvDataFile.getColumnByIndex(9)
    println(column)
    println("type: " + column.type())
    println("min: " + column.min())
    println("max: " + column.max())
}