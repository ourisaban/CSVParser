package csvParserUnitTest

import csvParser.CSVFile
import org.junit.jupiter.api.*
import java.io.BufferedReader


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