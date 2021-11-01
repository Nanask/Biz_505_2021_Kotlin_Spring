package com.callor.readbook.models


import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Spring Security에서 login 한 사용자(User, Member)정보를
 * 담아둘 VO 클래스
 */
data class MemberVO(
        // 이름을 통일하는 것이 좋다, 왠만하면 이걸 사용하자
        private var username:String,
        private var password:String,
        private var enabled:Boolean = true, // false라면 로그인은 가능하나 아무것도 하지말라
        private var credentialsNonExpired: Boolean = true, // 임의로 제거할 수 있음
        private var accountNonExpired:Boolean = true,
        private var accountNonLocked:Boolean = true,
        private var authorities:Collection<GrantedAuthority> = setOf()
//        var authorities:Collection<GrantedAuthority> = setOf()


) :UserDetails {
    override fun getUsername(): String = username
    override fun getPassword(): String = password
    override fun isEnabled(): Boolean = enabled
    override fun isAccountNonExpired(): Boolean = accountNonExpired
    override fun isCredentialsNonExpired(): Boolean = credentialsNonExpired
    override fun isAccountNonLocked(): Boolean = accountNonLocked
    override fun getAuthorities(): Collection<GrantedAuthority> = authorities
    fun setAuthorities(authorities: Collection<GrantedAuthority>) {
        this.authorities = authorities
    }





}


