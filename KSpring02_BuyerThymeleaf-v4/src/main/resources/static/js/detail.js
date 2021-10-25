$(function() {
    const buyerButton = $("section.buyer_detail button")
    const orderButton = $("section.order_detail button")
    if(buyerButton) { // button태그가 있는지 확인? 공용으로 되어있는 button에서 반드시 거쳐야 하는 부분, 이걸 하지 않으면 오류가 발생할 수 있음
        $(buyerButton).on("click",function() {
            const className = $(this).attr("class")
            let href = `${rootPath}buyer`
            if(className.includes("btn_update")) {
                alert(`Update ${userid}`)
                href=`${href}/update/${userid}`
            }else if(className.includes("btn_delete")) {
//                alert(`delete ${userid}`)
                if( !confirm("삭제할까요?")) {
                    href=`${href}/delete/${userid}`
                }else {
                    return false
                }
            }

            location.href = `${href}`
        })
    }
    if(orderButton) {
            $(orderButton).on("click",function() {
                const className = $(this).attr("class")
                let href = `${rootPath}order`
                if(className.includes("btn_update")) {
                    alert(`Update ${seq}`)
//                    alert(className +" 를 수정할까요??")
                    href =`${href}/update/${seq}`
                }else if(className.includes("btn_delete")) {
                    if( confirm("삭제할까요?")) {
                        href =`${href}/delete/${seq}`
                    }else {
                    return false
                   }
                }else if(className.includes("btn_list")) {
                    href=`redirect:/order`
                }

                location.href = `${href}`
            })
        }

})