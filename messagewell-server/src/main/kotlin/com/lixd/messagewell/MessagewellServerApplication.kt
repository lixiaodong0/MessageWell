package com.lixd.messagewell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MessagewellServerApplication

fun main(args: Array<String>) {
	runApplication<MessagewellServerApplication>(*args)
}
