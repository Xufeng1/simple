<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Diff File Tool</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="application/javascript" src="js/main.js"></script>
    <script type="application/javascript" src="js/jquery-form.js"></script>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            String value = cookie.getValue();
            if (cookie.getName().equals("username")) {
                flag = true;
                request.setAttribute("username", value);
                break;
            }
        }
    }
%>
<div>
    <form id="upload" method="post" enctype="multipart/form-data">
        源文件：<input type="file" id="source" name="source"/>
        目标文件：<input type="file" id="target" name="target"/>
        <input type="button" id="uploadFile" onclick="fileUpLoad()" value="比较差异"/>
    </form>
</div>

<c:if test="<%=!flag%>"><a href="/login.html">登录</a></c:if>

<c:if test="<%=flag%>">您好！ <%=request.getAttribute("username")%>
    <input type="button" onclick="exist()" value="退出登录"/>
</c:if>

<div>
    <span style="font-size: 20px">最近</span><span id="list-size"></span><span style="font-size: 20px">条历史对比结果</span>

    <table id="user-list" border="1">
    </table>
</div>

<%
    int listSize = 3;
%>
<input type="button" id="queryMore" onclick="queryDiffFiles(0, addListSize())" value="查看更多"/>

<input type="hidden" id="listSize" name="listSize" value="3"/>
</body>
</html>
