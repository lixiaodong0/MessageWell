package com.lixd.messagewell.service.impl

import com.lixd.messagewell.mapper.UserMapper
import com.lixd.messagewell.model.User
import com.lixd.messagewell.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userMapper: UserMapper

    override fun login(account: String, password: String): User? {
        val user = userMapper.login(account, password)
        if (user == null) {
            println("账号或密码错误")
            return user
        }
        return user
    }

    override fun register(account: String, password: String): Boolean {
        val findAccount = userMapper.findAccount(account) ?: ""
        if (findAccount.isNotEmpty()) {
            println("账户已存在")
            return false
        }
        val success = userMapper.register(account, password) ?: false
        if (!success) {
            println("注册失败")
            return false
        }
        return true
    }

    override fun findUser(id: String): User? {
        return userMapper.findUser(id)
    }

    override fun findAccount(account: String) {
        userMapper.findAccount(account)
    }

    override fun findAll() {
    }
}