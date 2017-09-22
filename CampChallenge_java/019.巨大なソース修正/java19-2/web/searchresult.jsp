<%@page import="java.util.List"
        import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // 検索結果が格納されたリクエストスコープパラメータ resultDataを取得
    List<UserDataDTO> udd = (ArrayList<UserDataDTO>) request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <!--　検索結果の画面で複数件ヒットしても、1件しか表示されない -->
            <% for(UserDataDTO result : udd) { %>
            <tr>
                <td><a href="ResultDetail?id=<%= result.getUserID()%>"><%= result.getName()%></a></td>
                <td><%= result.getBirthday()%></td>
                <!--　検索結果の画面で種別を数字から日本語に表示変更 -->
                <td><%= jh.exTypenum(result.getType())%></td>
                <td><%= result.getNewDate()%></td>
            </tr>
            <% } %>
        </table>
    </body>
    <!-- "トップページへ戻る"ボタンを表示 -->
    <%=jh.home()%>
</html>
