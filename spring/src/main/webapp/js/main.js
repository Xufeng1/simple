$(document).ready(function () {
    var listSize = 3;
    var page = 0;
    queryDiffFiles(page, listSize);
});

function fileUpLoad() {
    alert("sdfasdf");
    $("#upload").ajaxSubmit(subOptions);
}

var subOptions = {
    url: '/file/diff',
    type: "Post",
    dataType: "json",
    clearForm: true,
    beforeSubmit: function () {
        var source = $("#source").val();
        var target = $("#target").val();
        if (source == "" || target == "") {
            alert("文件不能为空");
            return false;
        }
    },
    success: function (data) {
        if (data.data !== null) {
            alert(data.data);
        } else {
            alert("文件比较异常！");
        }
        window.location.reload();
    }
};

function addListSize() {
    var listSize = document.getElementById("listSize");
    listSize.value = parseInt(listSize.value) + 2;
    return listSize.value;
}

function queryDiffFiles(page, pageSize) {
    var jsonData = {"page":page, "pageSize":pageSize};
    var json = JSON.stringify(jsonData);
    $.ajax({
        type: "POST",
        dataType: 'json',
        contentType: "application/json",
        url: "/file/list",
        data: json,
        success: function (data) {
            var list = data.data;
            var listlength = data.data.length;
            var str = "<tr><th>编号"
                + "</th><th>对比时间"
                + "</th><th>源文件内容"
                + "</th><th>目标文件内容"
                + "</th><td>差异</td>";
            if ($.cookie("username") != null) {
                str += "<td>操作</td>";
            }
            for (var i = 0; i < list.length; i++) {
                str += "<tr><td>" + list[i].id + "</td>"
                    + "<td>" + formateTimeStamp(list[i].diffTime) + "</td>"
                    + "<td>" + list[i].sourceFile.replace(/[\n]/g,"<br />") + "</td>"
                    + "<td>" + list[i].targetFile.replace(/[\n]/g,"<br />") + "</td>"
                    + "<td>" + list[i].difference.replace(/[\n]/g,"<br />") + "</td>";
                if ($.cookie("username") != null) {
                    str += "<td><button onclick=\"deleteDiff('" + list[i].id + "')\">删除</button></td></tr>";
                }
            }
            document.getElementById("user-list").innerHTML = str;
            document.getElementById("list-size").innerHTML = listlength;
            if (data.status == 0) {
                $("#queryMore").hide();
            } else {
                $("#queryMore").show();
            }

        }
    });
}

function deleteDiff(id) {
    $.ajax({
        type: "POST",
        dataType: 'json',
        url: "/file/delete",
        data: {id:id},
        success: function (data) {
            if (data.status == 0) {
                alert(data.message);
                window.location.reload();
            } else {
                alert(data.message);
            }
        }
    });
}

function formateTimeStamp(time) {
    var date = new Date();
    date.setTime(time);
    var year = date.getFullYear();
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
}

function exist() {
    $.ajax({
        type: "POST",
        dataType: 'json',
        url: "/user/exist",
        success: function (data) {
            if (data.status == 0) {
                window.location.reload();
            } else {
                alert(data.message);
            }
        }
    });
}