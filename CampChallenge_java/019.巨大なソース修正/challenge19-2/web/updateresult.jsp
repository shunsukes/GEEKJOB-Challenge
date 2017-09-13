<%@page import="jums.JumsHelper" 
        import="jums.UserDataDTO"
        import="java.util.Calendar" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // セッション開始
    HttpSession hs = request.getSession();
    // 1件のユーザー情報が格納されたセッションデータを取得 [ResultDetail.javaより]
    UserDataDTO udt = (UserDataDTO) request.getAttribute("updateData");
    // 誕生日を生年・月・日に分けるために、カレンダー型に変換　c.get(Calendar.YEAR)で生年取得
    Calendar c = Calendar.getInstance();
    c.setTime(udt.getBirthday());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
    <h1>変更結果</h1><br>
    名前:<%= udt.getName() %> <br>
    生年月日:<%= c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1)  + "月" + c.get(Calendar.DAY_OF_MONTH) + "日"%><br>
    種別:<%= jh.exTypenum(udt.getType()) %><br>
    電話番号:<%= udt.getTell() %><br>
    自己紹介文:<%= udt.getComment() %><br><br>
    以上の内容で登録しました。<br><br>
    <form action="ResultDetail" method="POST">
        <input type="hidden" name="id" value="<%= udt.getUserID() %>">
        <input type="submit" name="NO" value="詳細画面へ戻る">
    </form>
    <br>
    <!-- "トップページへ戻る"ボタンを表示 -->
    <%=jh.home()%>
    </body>
</html>
