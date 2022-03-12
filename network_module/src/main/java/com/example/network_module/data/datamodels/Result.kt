package com.example.network_module.data.datamodels
enum class Status {
    LOADING, ERROR, SUCCESS
}

data class Result<T>(val status: Status, val data: T?, val errorMessage: String) {


}