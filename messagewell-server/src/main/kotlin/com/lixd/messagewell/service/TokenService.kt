package com.lixd.messagewell.service

import com.lixd.messagewell.mapper.MoodMapper
import com.lixd.messagewell.mapper.TokenMapper
import com.lixd.messagewell.model.Token
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TokenService {

    @Autowired
    lateinit var tokenMapper: TokenMapper

    fun findToken(token: String): Token? {
        return tokenMapper.findToken(token)
    }

    fun saveToken(token: Token): Boolean {
        return tokenMapper.saveToken(token) ?: false
    }
}