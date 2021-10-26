$(function(){
    function tableClickHandler() {
        const seq = $(this).data("seq")
        location.href = `${rootPath}order/detail?seq=${seq}`
    }

    $("table.order_list tr").on("click", tableClickHandler)
})