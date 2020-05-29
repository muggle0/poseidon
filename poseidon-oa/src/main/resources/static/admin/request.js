function goIndex() {
    var $ = layui.jquery;
    $.ajax({
        type: "get",
        url: "index.html",
        dataType : "json",
        contentType : "application/json"
    })
}

