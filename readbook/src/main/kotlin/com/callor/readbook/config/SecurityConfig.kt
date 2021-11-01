package com.callor.readbook.config

import com.callor.readbook.service.MemberLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.stereotype.Service
import org.springframework.web.util.pattern.PathPattern


// 프로젝트 설정을 위한 클래스
@SpringBootConfiguration
// 프로젝트에 Spring Security 설정을 추가한다
// Spring Security를 Customizing 하겠다.
@EnableWebSecurity
class SecurityConfig:WebSecurityConfigurerAdapter() {

    // security 가 간섭하지 않도록 만드는 것
    override fun configure(web: WebSecurity) {
// *를 하나만 붙이면 파일들만 건들지 말라는 의미, **는 폴더, 파일 모두 건들지 말라는 의미
        web.ignoring().antMatchers("/static/**","static/css/**","static/js/**","static/images/**",
        "*.ico","*.txt")

        //yml에 설정되어 있는 정보를 ignore 하라
        web.ignoring().requestMatchers(
                // static안에 있는 Resource는 무시하라?
                PathRequest
                .toStaticResources()
                .atCommonLocations()
        )
    }

    //    @Autowired
//    lateinit var memberService: MemberLoginService

    // 인증절차를 수행하는 policy 설정
    // 누구를 대상으로 인증절차를 진행할 것인가.
    override fun configure(http: HttpSecurity) {

        // 요청이 들어왔는데 확인하겠다?
        // client로 부터 전달된 Req가 인가된 요청인가를 확인하겠다

        http.authorizeRequests()
                // member/mypage에 가면 요청을 받아라
                .antMatchers("/member/mypage")
                .authenticated() // mypage에 접속하면 인증을 받아라
                .antMatchers("/**")
                .permitAll() // 요청받은 것이 있는데, 모든 요청에 인가를 허가한다.

//        http.authorizeRequests()
//                // member/mypage에 가면 요청을 받아라
//                .antMatchers("/member/mypage")
//        http.authorizeRequests()
//                .antMatchers("/**")
//                .permitAll() // 요청받은 것이 있는데, 모든 요청에 인가를 허가한다.

        // 원래 http.authorizeRequests()를 쓰고 또 연결해줘야 함

        // antMatchers, mvcMathcher() 등은
        // authorizeRequests() 함수와 chaining 관계에 있는 함수들이다.
        // authorizeRequest() 함수아래에 다수의 antMatchers() 를
        // 계속해서 추가 할 수 있다.
        http.authorizeRequests()
                // member/mypage 로 req(요청)이 오면
                // 인증 절차를 수행하라 , 인증이 되어있지 않다면 로그인으로 보내라

                .antMatchers("/member/login").permitAll()
                .antMatchers("/member/mypage").authenticated() // authenticated() 인증을 검사하라, 이코드르를 통해 securyty 가 감시를 하기 시작함
                .antMatchers("/member/**").permitAll() // member url을 통하는 것들을 제외하고는 전부 통과시켜라
                .antMatchers("/home/**").authenticated()
                .antMatchers("/home/merry").authenticated() // 는 여기 있으면 적용할 수 없는 것
                .antMatchers("/**").permitAll()


        // 단독으로 사용되는 method 함수들은
        // http.함수 () 형식으로 사용한다
//        http.httpBasic()
//        http.formLogin()

        // 단독으로 사용되는 method 함수들을
        // chaining 방식으로 사용할 때는 and() 함수로 연결해준다.
                .and().httpBasic() // popup형태
//                .and().formLogin()  // 로그인 form 보이기
        // login form을 커스텀할 때는 단독으로 사용할 수 있도록 하자
            http.formLogin()
                // security 기본 form 화면을 보이는 대신
                // 내가 만든 MemberController의 login으로
                // redirect 하라
                .loginPage("/member/login").permitAll()
                // 로그인을 할 때 어떤 url을 쓸 것인가
                .loginProcessingUrl("/login")
                .usernameParameter("userid")
                .passwordParameter("pass")

            http.logout()
                    // logoutRequestMatcher에게 logout이 요청이 되면 "/"으로 이동하라
                    // ${rootPath}/logout 으로 요청이 들어오면 logout을 수행하라
                    .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                    // logout이 정상적으로 수행되면
                    // /member/mypage로 redirect를 수행하라
                    .logoutSuccessUrl("/member/mypage")


    } // config(http) end

    /**
     *   .password("{noop}12341234")
     *   Spring Security 에서 제공하는 password 정책
     *   5.x 버전이상에서는 의무적으로 password 를 DB에 저장하거나
     *   비교연산등을 할 때 반드시 암호화를 하도록 강제하고 있다
     *
     *   아직 암호화를 구현하지 않을 상태에서 테스트를 하기 위해
     *   임시로 암호화 되지 않은 비밀번호를 사용해서
     *   비밀번호 비교를 하겠다라는 의미
     */

    override fun configure(auth: AuthenticationManagerBuilder) {

//        // id, pw가 일치하는 사용자에게 admin를 줘라
//            auth.inMemoryAuthentication()
//                .withUser("callor")
//                .password("{noop}12341234")
//                .roles("USER","ADMIN")

        //security야 UserDetailService 인터페이스를 상속받은
        // memberLoginService 클랫의 객체를 너에게 건내주니
        // 회원 정보 인증을 할 때 사용하라
        // MemberLoginService.loadUserByUserName() 함수를 실행하여
        // 사용자 정보를 나에게 달라.
        // 그러면 auth에 사용자 데이터가 담기게 됨
        auth.userDetailsService(MemberLoginService())
                // auth에 담긴 사용자정보에서 password 항목을 찾아서
                // customPasswordEncoder() 에게 보내서
                // 비밀번호가 맞는지 검사하라.
            .passwordEncoder(CustomPasswordEncoder())
    }
}

class CustomPasswordEncoder:PasswordEncoder {
    override fun encode(plan: CharSequence): String {
        return plan.toString()
    }

    // 여기가 암호화 처리를 해야 하는 곳인데, 그거 설정안해서 그냥 return하는 곳인가?
    // 암호화 처리를 못하니까, 그냥 일치하면 return하는 것으로 넘긴거같은데욤
    override fun matches(plan: CharSequence?, crypt: String?): Boolean {
        return true
    }


}