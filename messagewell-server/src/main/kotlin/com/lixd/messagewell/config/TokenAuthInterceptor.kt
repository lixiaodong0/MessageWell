package com.lixd.messagewell.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.lixd.messagewell.bean.BaseResult
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class TokenAuthInterceptor : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader("token")
        if (token.isNullOrEmpty()) {
            val result = BaseResult.failure<String>(-1, "please login")
            val json = ObjectMapper().writeValueAsString(result)
            response.writer.write(json)
            return false
        }
        return true
    }
}