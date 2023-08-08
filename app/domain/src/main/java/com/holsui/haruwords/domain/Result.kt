package com.holsui.haruwords.domain

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Failure(val error: Error) : Result<Nothing>
    object Loading : Result<Nothing>
}
