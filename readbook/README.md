# ReadBook Project V3 with Spring Security

* 2021-11-01
* 똑소리 나는 독서록 프로젝트에 Spring Security를 적용하여 로그인 기능 구현
* Spring Security를 적용하면 로그인, 로그인 후 session 관리 등을 좀 더 편리하게 구현 할 수 있다.
  Spring Security는 초기 설정이 다소 어렵고 불편하지만, 초기 설정이 잘 되면 상당부분을 개발자가 직접
  핸들링 하지 않고도 인가,인증,권한 설정등을 쉽게 할 수 있다.


# Security 관련된 용어 정리
* 인증(Authentication) : username, password 를 사용하여 허가된 사용자 인지를 판별하는 것
* 인가(Authorization) : 로그인이 된 사용자에게 권한을 허락(부여) 하는 것
* 권한설정(Authority, Role) : 인증받은 사용가의 인가 정보를 확인하여 접근할 수 있는 곳(페이지) 등을
  확인하고, 적절히 처리하는 것, ADMIN, GUEST 등의 역할을 부여하여 처리하기

* 예로) korea라는 username 을 가진 사용자가 로그인을 했다
1. korea user가 정상적인 절차를 거쳐서 회원가입이 되고, 본인 확인 절차를 통과했는가?
   자신의 mypage에 접근할 수 있는 권한을 부여한다
2. korea user에게 사전에 미리 부여된 역할이 무엇인가를 판단?
   USER(일반)이다 : mypage 에서 자신의 정보를 보기, 수정, 삭제 등을 할 수 있게 한다.
   ADMIN(관리자)도 포함되어 있다 : 자신의 mypage에 접근 할 수 있고, 다른 USER의 리스트를 보고
   뭔가 실행을 할 수 있다.

#Spring security 를 사용한 Login 구현
* SecurityConfig(WebSecurityConfigurerAdapter 상속)에 login form 을 custom 할 수 있다
* 이때 login form 의 method 는 반드시 post 로 action=${rootPath}/login 으로 설정
* 즉, security 에서 제공하는 loginProcessor Url 로 login 정보를 request 하기
Spring security 에서 기본으로 제공하는 login 기능을 사용하겠다 라는 의미
* 기본 login 기능은 username 과 password 값을 받아서 인증 절차를 수행한다.
* 만약 인증 절차가 실패(id가 없거나 또는 password 가 틀리면)하면 무조건 원래의 login(/member/login)으로 redirect 한다.
* 이때, error 라는 매개변수(params)를 전달한다.
* thymeleaf 로 만든 login form 에서는 th:if=${param.login} 코드를 사용하여
    오류가 발생했음을 view 에 보여줄 수 있다.

#Spring Security login LOGIC 흐름
1. authenticated 가 설정된 page 에 접근(Request)
2. login 정보가 있는 지 확인?
3. 없으면 loginPage()가 설정된 곳으로 redirect : login.html
4. 로그인 수행 : ${rootPath}/login 으로 POST 전송
5. configure(auth: AuthenticationManagerBuilder) 에 설정된 동작을 수행한다.
6. auth.userDetailsService(MemberLoginService()) 설정을 확인
    1. MemberLoginService() 클래스가 지정되어 있다 
    2. 이 클래스는 UserDetailsService interface 를 상속받아 작성 된 클래스이다
    3. 이 클래스의 loadUserByUserName() method 를 실행한다
    4. loadUserByUserName() method 는 username 을 기준으로 사용자 정보를 조회하여 MemberVO 객체 데이터를 만든다
    5. 그리고 configure 의 auth 에게 MemberVO를 전달한다.

#login 수행절차
1. localhost:8080/member/mypage 에 접근하려고 시도
2. 순간 controller 로 전달되기 전에 security 의 filter 가 가로채기
3. SecurityConfig.configure(http:..)