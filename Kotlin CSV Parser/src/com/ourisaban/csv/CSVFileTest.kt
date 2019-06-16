package com.ourisaban.csv

import com.ourisaban.csv.parser.CSVFile
import org.junit.jupiter.api.*


class CSVFileTest {

    private lateinit var csvFile: CSVFile

    @BeforeEach
    fun beforeEachTest() {
        csvFile = CSVFile("test.csv")
    }

    @Test
    fun testCSVFileCompile() {
        val csvDataFile = csvFile.compile(true, ',')
        Assertions.assertEquals(18, csvDataFile.getNbColumn())
        Assertions.assertTrue(csvDataFile.isHeader)
    }

}