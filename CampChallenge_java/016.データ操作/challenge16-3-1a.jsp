<%-- 
    Document   : challenge16-3-1a
    Created on : 2017/09/05, 13:33:36
    Author     : maruyamashunsuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            int type = Integer.parseInt(request.getParameter("type"));
            switch (type) {
                case 1:
                    out.print("商品種別 ：雑貨 <br>");
                    break;
                case 2:
                    out.print("商品種別 ：生鮮食品 <br>");
                    break;
                case 3:
                    out.print("商品種別：その他 <br>");
                    break;
            }
            
            int total = Integer.parseInt(request.getParameter("total"));
            int count = Integer.parseInt(request.getParameter("count"));
            out.print("総額　　 ：" + total + "円 <br>");
            out.print("個数　　 ：" + count + "個 <br>");
            out.print("1個あたり：" + (total / count) + "円<br><br>");
            
            out.print("総額 3000円以上で4%, 5000円以上で5%のポイントが付きます。<br>");
            
            if(total > 5000){
                out.print("→　" + Math.round((total * 0.05)) + "ポイントをもらいました。");
                
            } else if(total > 3000){
                out.print("→　" + Math.round((total * 0.04)) + "ポイントをもらいました。");
            } else {
                out.print("→　今回はポイントをもらえませんでした。");
            }
            
        %>
    </body>
</html>
