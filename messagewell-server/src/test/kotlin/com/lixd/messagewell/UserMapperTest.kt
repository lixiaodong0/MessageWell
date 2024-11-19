package com.lixd.messagewell

import com.lixd.messagewell.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test

@SpringBootTest
class UserMapperTest {

    @Autowired
    lateinit var userMapper: UserMapper

    @Test
    fun test() {
        val result = userMapper.register("111", "2222")
        println("result:${result}")
    }

    @Test
    fun login() {
        val result = userMapper.login("111", "2222")
        println("result:${result}")
    }

    @Test
    fun findAccount() {
        val result = userMapper.findAccount("111")
        println("result:${result}")
    }

    @Test
    fun findAll() {
        val result = userMapper.findAll()
        println("result:${result}")
    }
}