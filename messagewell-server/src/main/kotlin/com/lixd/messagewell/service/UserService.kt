package com.lixd.messagewell.service

import com.lixd.messagewell.model.User

interface UserService {

    fun login(account: String, password: String): User?

    fun register(account: String, password: String): Boolean

    fun findUser(id: String): User?

    fun findAccount(account: String)

    fun findAll()
}