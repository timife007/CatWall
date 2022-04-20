package com.example.catwall.logging

object Logger {
    fun log(priority: Int, tag: String?, message: String?) {
        // TODO add log entry to circular buffer.
    }

    fun logWarning(t: Throwable?) {
        // TODO report non-fatal warning.
    }

    fun logError(t: Throwable?) {
        // TODO report non-fatal error.
    }

    private fun Logger() {
        throw AssertionError("No instances.")
    }
}