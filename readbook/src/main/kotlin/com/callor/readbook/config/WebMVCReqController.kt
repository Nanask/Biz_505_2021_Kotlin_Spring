package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

// test를 위한 임시 컨트롤러 생성
/**
 * Controller를 만들지 않고 MVC 패턴의 가상의 Request 를 처리하는
 * class
 */
@SpringBootConfiguration
class WebMVCReqController:WebMvcConfigurer {

    // 보통테스트 할 때 사용
    // mypage로 갔을 때 mypage를 보여줘라
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/member/view")
                .setViewName("member/view")
    }
}