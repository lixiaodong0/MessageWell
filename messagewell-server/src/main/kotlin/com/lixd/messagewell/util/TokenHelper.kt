package com.lixd.messagewell.util

import java.util.UUID

object TokenHelper {
    fun generate(curUserId: Int): String {
        val uuid = UUID.randomUUID().toString()
        return uuid
    }
}