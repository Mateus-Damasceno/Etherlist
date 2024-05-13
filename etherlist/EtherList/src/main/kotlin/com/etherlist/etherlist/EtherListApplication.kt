package com.etherlist.etherlist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class EtherlistApplication

fun main(args: Array<String>) {
	runApplication<EtherlistApplication>(*args)
}
