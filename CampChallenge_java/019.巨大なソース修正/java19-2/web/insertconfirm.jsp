<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    // セッション開始
    HttpSession hs = request.getSession();
    // 入力情報が格納されたセッションデータ udbを取得
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
    // 入力内容に不備がないか確認 [UserDataBeans.java]
    List<String> chkList = udb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <!-- 全て入力されていた場合 -->
    <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName() %><br>
        生年月日:<%= udb.getYear() %>年<%= udb.getMonth() %>月<%= udb.getDay() %>日<br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell() %><br>
        自己紹介:<%= udb.getComment() %><br>
        <br>
        上記の内容で登録します。よろしいですか？<br><br>
        <form action="insertresult" method="POST">
            <!-- ac:不正アクセス防止用データ を[InsertConfirm.java]へ送信 -->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <!-- 入力情報を[Insertresult.java]へPOSTで送信するボタン -->
            <input type="submit" name="yes" value="はい" style="width:80px">
        </form>
    <!-- 入力内容に不備があった場合 -->
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <!-- 不備の項目を表示 [JumsHelper.java] -->
        <%= jh.chkinput(chkList) %>
    <% } %>
    <form action="insert" method="POST">
        <!-- 再入力であることを表す値、REINPUTを送信 -->
        <input type="hidden" name="mode" value="REINPUT">
        <!-- 登録画面に移動するボタン [insert.java] → [insert.jsp] -->
        <input type="submit" name="no" value="いいえ" style="width:80px">
        </form>
        <br>
        <!-- "トップページへ戻る"ボタンを表示 -->
        <%=jh.home()%>
    </body>
</html>
