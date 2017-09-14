<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    // セッション開始
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
    <h1>詳細情報</h1>
    名前:<%= udd.getName() %><br>
    生年月日:<%= udd.getBirthday() %><br>
    種別:<%= jh.exTypenum(udd.getType()) %><br>
    電話番号:<%= udd.getTell() %><br>
    自己紹介:<%= udd.getComment() %><br>
    登録日時:<%= udd.getNewDate() %><br><br>
    <form action="Update" method="POST">
        <input type="submit" name="update" value="変更" style="width:120px">
    </form>
    <form action="Delete" method="POST">
        <input type="submit" name="delete" value="削除" style="width:120px">
    </form>
    <!-- 修正⑧　ユーザー詳細ページから検索結果へ戻る機能 -->
    <input type="button" value="検索結果へ戻る" onclick="history.back()" style="width:120px">
    <br><br>
    <!-- "トップページへ戻る"ボタンを表示 -->
    <%=jh.home()%>
    </body>
</html>
