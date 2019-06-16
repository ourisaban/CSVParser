package com.ourisaban.csv.parser

import java.lang.Exception

/**
 * @author Ouri Saban
 *
 * This class handles errors; For now it just return a local exception so the user will from where it comes from.
 *
 * @param message the description of the exception.
 * @param cause the cause of the exception/ Allows us to trace the error
 */
class CSVFileException(message: String?, cause: Throwable?): Exception(message, cause)