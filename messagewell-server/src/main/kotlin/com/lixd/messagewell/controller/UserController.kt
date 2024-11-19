package com.lixd.messagewell.controller

import com.lixd.messagewell.model.BaseResult
import com.lixd.messagewell.model.User
import com.lixd.messagewell.service.UserService
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * 用户Controller
 */
@RequestMapping("/user")
@RestController
@Validated
class UserController {
    @Autowired
    lateinit var userService: UserService

    /**
     * 注册接口
     */
    @PostMapping("/register")
    fun register(
        @NotEmpty(message = "请输入账户") account: String,
        @NotEmpty(message = "请输入密码")
        @Size(min = 4, max = 20, message = "密码格式不正确，4~10位")
        password: String
    ): BaseResult<String?> {
        val success = userService.register(account, password)
        if (success) {
            return BaseResult.success(null)
        }
        return BaseResult.failure(-1, "注册失败，账户已存在")
    }

    /**
     * 登录接口
     */
    @PostMapping("/login")
    fun login(
        @NotEmpty(message = "账号不能为空")
        account: String,
        @NotEmpty(message = "账户密码不能为空")
        password: String
    ): BaseResult<User> {
        val user = userService.login(account, password)
        if (user != null) {
            return BaseResult.success(user)
        }
        return BaseResult.failure(-1, "账号或密码错误")
    }
}