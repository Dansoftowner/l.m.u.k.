package org.lmuk

import kotlin.system.exitProcess

fun checkExit(input: String?): String? {
    return if (input == "exit") exitProcess(0) else input
}