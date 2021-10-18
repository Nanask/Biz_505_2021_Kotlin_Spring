package com.callor.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// 아무것도 없는 클래스를 만들고 SpringBootApplication 를 붙이면
// web.xml 파일을 대신하는 boot 클래스가 만들어진다.
// boot에는 tomcat이 내장되어있음
// 스프링 부트에서는 이게 시작파일!
@SpringBootApplication
class KSpringApplication

fun main(args: Array<String>) {
	runApplication<KSpringApplication>(*args)
}
