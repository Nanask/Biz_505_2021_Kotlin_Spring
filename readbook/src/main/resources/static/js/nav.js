$(function () {
    $("nav li").on("click", function(){
        const text = $(this).text()

        // let href="/"
        if(text === "Home") {
            alert("홈")
            location.href=`${rootPath}`
        }else if(text === "도서 등록") {
            alert("등록")
            location.href=`${rootPath}insert`
        }else if(text === "도서 목록") {
            alert("목록")
            location.href=`${rootPath}list`
        }else if(text === "로그인") {
            alert("로그인")
            location.href=`${rootPath}member/login`
        }else if(text === "MyPage") {
            alert("My Page")
            location.href=`${rootPath}member/mypage`
        }
    })
})