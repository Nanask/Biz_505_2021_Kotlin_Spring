package com.callor.readbook.service

import com.callor.readbook.models.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Security login Service 클래스
 * (*UserDetailService)
 */

@Service
class MemberLoginService : UserDetailsService {

    // 가상의 MemberList 만들기
    val userList = listOf(
            MemberVO(username="callor", password = "1234"),
            MemberVO(username="callor88", password = "1234"),
            MemberVO(username="callorok", password = "1234")
    )

    //  사용자 아이디를 가지고 사용자를 조회해서, DB에 추가되어있으면
    // 그 정보를 return 하라
    // findByUserName(username) : UserDetails
    override fun loadUserByUsername(username: String): UserDetails {

        // 배열.find{} : 배열의 요소 중 원하는 값이 담겨 있는가?
        // 담겨 있으면 해당 값을 return 하고, 없으면 null return
        val member:UserDetails? = userList.find { it.username == username }

        // 조회한 user값이 null값이면 강제로 throw(exception)처리를 하라
        // 그렇게 되면 try_catch로 catch하게 되면서 redirect 화면에서 div에 입력해놓은 오류메세지를 보인다.
            member ?:throw UsernameNotFoundException("사용자 ID가 잘못되었습니다.")

            return member
    }
}