package com.ourisaban.csv

import com.ourisaban.csv.parser.CSVDataFile
import com.ourisaban.csv.parser.CSVFile
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CSVDataFileTest {
    private lateinit var csvDataFile: CSVDataFile

    @BeforeEach
    fun beforeEachTest() {
        csvDataFile = CSVFile("test.csv").compile(true, ',')
    }

    @Test
    fun testCSVDataFileColumnMin() {
        Assertions.assertEquals(73.37, csvDataFile.getColumnByIndex(8).min())
    }

    @Test
    fun testCSVDataFileColumnMax() {
        Assertions.assertEquals(1.701E9, csvDataFile.getColumnByIndex(8).max())
    }

    @Test
    fun testRetrieveColumnByHeader() {
        Assertions.assertTrue(csvDataFile.isHeader)
        Assertions.assertNotNull(csvDataFile.getColumnByHeader("statecode"))
    }
}