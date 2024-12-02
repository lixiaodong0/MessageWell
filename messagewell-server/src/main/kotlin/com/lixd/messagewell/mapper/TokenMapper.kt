package com.lixd.messagewell.mapper

import com.lixd.messagewell.model.Token

interface TokenMapper {
    fun findToken(token: String): Token?

    fun saveToken(token: Token): Boolean?
}