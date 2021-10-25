$(function() {

    function tableClickHandler() {
          const id = $(this).data("id")
          alert("id : " + id)
          location.href = "/order/detail?seq=" + id
    }

    $("table.order_list tr").on("click", tableClickHandler)
})