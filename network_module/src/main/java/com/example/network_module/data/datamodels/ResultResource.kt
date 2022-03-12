package com.example.network_module.data.datamodels

enum class Status {
    LOADING, ERROR, SUCCESS
}

data class ResultResource<out T>(val status: Status, val data: T?, val errorMessage: String?) {

    companion object {
        fun <T> success(data: T) = ResultResource(Status.SUCCESS, data, null)
        fun <T> loading() = ResultResource(Status.LOADING, null, null)
        fun <T> fail(errorMessage: String?) = ResultResource(Status.ERROR, null, errorMessage)
    }

}