package com.lixd.messagewell.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.lixd.messagewell.bean.BaseResult
import com.lixd.messagewell.service.MoodService
import com.lixd.messagewell.service.TokenService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class TokenAuthInterceptor : HandlerInterceptor {
    @Autowired
    lateinit var tokenService: TokenService

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader("token")
        if (token.isNullOrEmpty()) {
            val result = BaseResult.failure<String>(-1, "please login")
            val json = ObjectMapper().writeValueAsString(result)
            response.writer.write(json)
            return false
        }
        val tokenModel = tokenService.findToken(token)
        if (tokenModel == null) {
            val result = BaseResult.failure<String>(-1, "token expiration")
            val json = ObjectMapper().writeValueAsString(result)
            response.writer.write(json)
            return false
        }
        return true
    }
}