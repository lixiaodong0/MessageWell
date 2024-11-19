package com.lixd.messagewell.model

data class BaseResult<T>(
    val code: Int,
    val msg: String,
    val data: T?,
) {
    companion object {
        fun <T> success(data: T?): BaseResult<T> {
            return BaseResult(0, "success", data)
        }

        fun <T> failure(code: Int, msg: String): BaseResult<T> {
            return BaseResult(code, msg, null)
        }
    }
}
