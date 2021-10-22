$(function() {
    // 저장버튼을 클릭했을 때
    const buyerButton = $("form.buyer button")
    const orderButton = $("form.order button")

    if(buyerButton) {
         $(buyerButton).on("click",function(){
            const className = $(this).attr("class")
            if(className.includes("btn_save")) {
                alert("buyer클릭")
                $("form").submit()
            }else {
                return false
            }

         })
   }
    if(orderButton) {
         $(orderButton).on("click",function(){
            const className = $(this).attr("class")
            if(className.includes("btn_save")) {
                alert("orderClick")
                $("form").submit()
            }else {
                return false
            }

         })
   }

})