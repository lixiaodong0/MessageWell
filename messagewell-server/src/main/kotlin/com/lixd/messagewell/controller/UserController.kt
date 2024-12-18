package com.lixd.messagewell.controller

import com.lixd.messagewell.bean.BaseResult
import com.lixd.messagewell.bean.`in`.LoginParams
import com.lixd.messagewell.bean.`in`.RegisterParams
import com.lixd.messagewell.model.Token
import com.lixd.messagewell.model.User
import com.lixd.messagewell.service.TokenService
import com.lixd.messagewell.service.UserService
import com.lixd.messagewell.util.TokenHelper
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * 用户Controller
 */
@RequestMapping("/user")
@RestController
class UserController {
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var tokenService: TokenService

    /**
     * 注册接口
     */
    @PostMapping("/register")
    fun register(
        @RequestBody
        registerParams: RegisterParams
    ): BaseResult<String?> {
        val success = userService.register(registerParams.account, registerParams.password)
        if (success) {
            return BaseResult.success(null)
        }
        return BaseResult.failure(-1, "注册失败，账户已存在")
    }

    /**
     * 登录接口
     */
    @PostMapping("/login")
    fun login(@Validated loginParams: LoginParams): BaseResult<User> {
        val user = userService.login(loginParams.account ?: "", loginParams.password ?: "")
        if (user != null) {
            val token = TokenHelper.generate(user.id)
            tokenService.saveToken(Token(user.id, token))
            user.token = token
            return BaseResult.success(user)
        }
        return BaseResult.failure(-1, "账号或密码错误")
    }
}