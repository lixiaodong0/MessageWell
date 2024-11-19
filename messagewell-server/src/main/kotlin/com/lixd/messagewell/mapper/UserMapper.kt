package com.lixd.messagewell.mapper

import com.lixd.messagewell.model.User

interface UserMapper {
    fun findAll(): List<User>?
    fun findAccount(account: String): Boolean?
    fun register(account: String, password: String): Boolean?
    fun login(account: String, password: String): User?
}