package com.lixd.messagewell

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.lixd.messagewell.mapper")
class MessagewellServerApplication

fun main(args: Array<String>) {
    runApplication<MessagewellServerApplication>(*args)
}
