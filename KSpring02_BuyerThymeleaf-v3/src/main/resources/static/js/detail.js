$(function() {
    const button = $("section.buyer_detail button")
    if(button) { // button태그가 있는지 확인? 공용으로 되어있는 button에서 반드시 거쳐야 하는 부분, 이걸 하지 않으면 오류가 발생할 수 있음
        $(button).on("click",function() {
            const className = $(this).attr("class")
            let href = `${rootPath}buyer`
            if(className.includes("btn_update")) {
                alert(`Update ${userid}`)
                href=`${href}/update/${userid}`
            }else if(className.includes("btn_delete")) {
//                alert(`delete ${userid}`)
                href=`${href}/delete/${userid}`
            }

            location.href = `${href}`
        })
    }
})