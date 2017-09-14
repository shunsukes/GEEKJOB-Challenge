<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    // セッション開始
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
    udb = (UserDataBeans) hs.getAttribute("searchInfo");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    <form action="SearchResult">
        <input type="hidden" name="name" value="<%= udb.getName() %>">
        <input type="hidden" name="year" value="<%= udb.getYear() %>">
        <input type="hidden" name="type" value="<%= udb.getType() %>">
        <input type="submit" value="検索結果に戻る">
    </form>
    <br>
    <!-- "トップページへ戻る"ボタンを表示 -->
    <%=jh.home()%>
    </body>
</html>
