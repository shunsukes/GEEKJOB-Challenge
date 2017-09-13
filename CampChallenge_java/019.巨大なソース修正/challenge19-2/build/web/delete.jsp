<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="java.util.Calendar" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // セッション開始
    HttpSession hs = request.getSession();
    // 1件のユーザー情報が格納されたセッションデータを取得 [ResultDetail.javaより]
    UserDataDTO udt = (UserDataDTO) hs.getAttribute("resultData");
    // 誕生日を生年・月・日に分けるために、カレンダー型に変換　c.get(Calendar.YEAR)で生年取得
    Calendar c = Calendar.getInstance();
    c.setTime(udt.getBirthday());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    名前:<%= udt.getName() %> <br>
    生年月日:<%= c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1)  + "月" + c.get(Calendar.DAY_OF_MONTH) + "日"%><br>
    種別:<%= jh.exTypenum(udt.getType()) %><br>
    電話番号:<%= udt.getTell() %><br>
    自己紹介文:<%= udt.getComment() %><br><br>
    このレコードを本当に削除しますか？<br><br>
    
    <form action="DeleteResult" method="POST">
      <!-- ac:不正アクセス防止用データ を[UpdateResult.java]へ送信 -->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac") %>">
        <!-- id:どのデータを更新するか設定するため、userIDを[UpdateResult.java]へ送信 -->
        <input type="hidden" name="id" value="<%= udt.getUserID() %>">
        <input type="submit" name="YES" value="はい" style="width:110px">
    </form>
    <form action="ResultDetail" method="POST">
        <input type="hidden" name="id" value="<%= udt.getUserID() %>">
        <input type="submit" name="NO" value="いいえ" style="width:110px">
    </form>
    </body>
</html>
