package csvParser

import java.io.BufferedReader
import java.time.LocalTime
import java.util.*
import kotlin.collections.ArrayList

class CSVDataFile(fileReader: BufferedReader, val isHeader: Boolean, delimiter: Char) {
    private val fileReader = fileReader
    private val delimiter = delimiter
    private var _table: LinkedList<Column> = LinkedList()

    init {
        buildColumns()
    }

    private fun buildColumns() {
        var line = read()
        if (line != null){
            line.forEachIndexed { index, data ->
                if (isHeader)
                    _table.add(Column(data, ArrayList()))
                else
                    _table.add(Column(index, arrayListOf(data)))
            }
        }

        line = read()
        while (line != null) {
            line.forEachIndexed { index, data ->
                var column: Column? = null
                try {
                    column = _table[index]
                } catch (ex: Throwable) {
                    _table.add(Column(index, arrayListOf(data)))
                }
                if (column != null)
                    column.data.add(data)
            }
            line = read()
        }
    }

    private fun read(): List<String>? = fileReader.readLine()?.split(delimiter)

    fun getColumnByIndex(index: Int) = this._table[index]

    fun getColumnByHeader(header: String) = this._table.find { header.compareTo(it.header as String) == 0 }

    fun getNbColumn() = this._table.size
}