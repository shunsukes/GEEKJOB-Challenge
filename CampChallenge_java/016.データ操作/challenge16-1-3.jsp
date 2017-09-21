<%-- 
    Document   : challenge16-1-3
    Created on : 2017/09/21, 11:14:31
    Author     : maruyamashunsuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!--背景色の指定-->
    <body bgcolor="gold">
        <!--リンクの指定-->
        <h1><a target="_brank" href="https://www.apple.com/">apple<a/><h1><br>
                    
        <!--画像の表示-->     
        <img src="gazou.jpg" alt="Sample"><br>
        
        <!--表の作成-->
        <table>
            <tr>
                <th>名前</th>
                <th>年齢</th>
                <th>出身県</th>
            </tr>
            <tr>
                <td>山田</td>
                <td>20</td>
                <td>東京</td>
            </tr>
            <tr>
                <td>佐藤</td>
                <td>30</td>
                <td>神奈川</td>
            </tr>
        </table>
        
        <!--箇条書きの作成と段落の作成-->
        <p>
        好きな食べ物
            <ul>
                <li>カレー</li>
                <li>ラーメン</li>
                <li>すき焼き</li>
            </ul>
        </p>
        <!--ルビを追加する-->
        <ruby>
            青
            <rt>
            <!--フォントの色指定-->
            <font color="red">きいろ</font> 
            </rt>
        </ruby>
        
        <!--文字サイズの指定、段落の作成-->
        <h4>上を<p>向いて</p>歩こうく</h4>
        
        <!--プルダウンボックスの作成-->
        <select>
            <option value="0">succer</option>
            <option value="1">baseball</option>
            <option value="2">basketball</option>
        </select>

        <!--文字を斜めにする-->
        <h1>Hello World!<i>Hello World!</i></h1>
    </body>
</html>
