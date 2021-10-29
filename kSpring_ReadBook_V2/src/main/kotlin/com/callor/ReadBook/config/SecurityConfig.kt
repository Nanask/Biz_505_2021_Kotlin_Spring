package com.callor.ReadBook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
//@EnableWebSecurity가 security를 갖고온다고...?
@EnableWebSecurity
class SecurityConfig:WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {

        //mvcMatcher() 어떤 url을 설정할 것인가
        http.authorizeRequests()
                // "/member/mypage"로 요청이 들어오면 인증을 받아라!
                .antMatchers("/member/mypage").authenticated()
                // 인증이 되지 않는다면 그냥 통화시켜라
                .antMatchers( "/**").permitAll() // 아무나 사용가능
                .mvcMatchers("/**").anonymous()
        // 함수체이닝? // 인증이 되지 않았다면 팝업창을 띄워서 로그인을 받아라
//        http.httpBasic()
        // 만약 인증이 필요한 페이지에 권한이 없이 접근하면
        // member/login으로 redirect하라
        http.formLogin()
                .loginPage("/member/login").permitAll()
    }
}