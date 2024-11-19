package com.lixd.messagewell.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 用户Controller
 */
@RequestMapping("/user")
@RestController
class UserController {
    /**
     * 注册接口
     */
    @PostMapping("/register")
    fun register() {

    }

    /**
     * 登录接口
     */
    @PostMapping("/login")
    fun login() {

    }
}