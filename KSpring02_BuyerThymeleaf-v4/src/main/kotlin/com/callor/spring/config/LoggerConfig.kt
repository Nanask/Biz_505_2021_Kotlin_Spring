package com.callor.spring.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * kotlin은 객체 지향 프로그래밍 언어이면서
 * 함수지향 프로그래밍 언어
 *
 * inline 함수
 * 클래스에서 함수를 호출하여 사용할 때
 * 자동으로 호출한 클래스 자체를 함수에 전달하고
 * 전달받은 클래스를 사용하여
 * 코드가 실행되는 동안 객체를 다시 생성하는 독특한 함수
 */

// 코틀린문법
// 함수를 호출한 class가 T에 담겨서 T대신 호출한 class를 부착시켜 재사용시킴
//Any 누구나, 아무나 라는 표시, 어디서든 클래스를 호출할 수 있도록 하는 것
 inline fun <reified T:Any> T.logger(): Logger {

//    return LoggerFactory.getLogger(Class::class.java)
    return LoggerFactory.getLogger(T::class.java)
}
// 두개의 코드는 동일하다.


// 람다코드
inline fun <reified T:Any> T.loggerFor() = LoggerFactory.getLogger(T::class.java)