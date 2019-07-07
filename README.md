Welcome to CSVParser Kotlin library

1. You can access CSVFile class by inputing a filename, inputstream.
2. Function Compile of CSVFile object will build a simple lite weigth scheme of your csv file and return you a CSVDataFile Object.
3. the CSVDataFile give you possibility to retrieve column you want, min or max and type

```val file = CSVFile("test.csv")
    val csvDataFile: CSVDataFile = file.compile(true, ',')
    println(csvDataFile.getNbColumn())
    val column: Column = csvDataFile.getColumnByIndex(9)
    println(column)
    println("type: " + column.type())
    println("min: " + column.min())
    println("max: " + column.max())```
