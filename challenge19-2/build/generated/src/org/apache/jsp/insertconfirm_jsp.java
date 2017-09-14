package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans;

public final class insertconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    JumsHelper jh = JumsHelper.getInstance();

    // セッション開始
    HttpSession hs = request.getSession();
    // 入力情報が格納されたセッションデータ udbを取得
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
    // 入力内容に不備がないか確認 [UserDataBeans.java]
    List<String> chkList = udb.chkproperties();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <!-- 全て入力されていた場合 -->\n");
      out.write("    ");
 if(chkList.size()==0){ 
      out.write("\n");
      out.write("        <h1>登録確認</h1>\n");
      out.write("        名前:");
      out.print( udb.getName() );
      out.write("<br>\n");
      out.write("        生年月日:");
      out.print( udb.getYear() );
      out.write('年');
      out.print( udb.getMonth() );
      out.write('月');
      out.print( udb.getDay() );
      out.write("日<br>\n");
      out.write("        種別:");
      out.print( jh.exTypenum(udb.getType()));
      out.write("<br>\n");
      out.write("        電話番号:");
      out.print( udb.getTell() );
      out.write("<br>\n");
      out.write("        自己紹介:");
      out.print( udb.getComment() );
      out.write("<br>\n");
      out.write("        <br>\n");
      out.write("        上記の内容で登録します。よろしいですか？<br><br>\n");
      out.write("        <form action=\"insertresult\" method=\"POST\">\n");
      out.write("            <!-- ac:不正アクセス防止用データ を[InsertConfirm.java]へ送信 -->\n");
      out.write("            <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("            <!-- 入力情報を[Insertresult.java]へPOSTで送信するボタン -->\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\" style=\"width:80px\">\n");
      out.write("        </form>\n");
      out.write("    <!-- 入力内容に不備があった場合 -->\n");
      out.write("    ");
 }else{ 
      out.write("\n");
      out.write("        <h1>入力が不完全です</h1>\n");
      out.write("        <!-- 不備の項目を表示 [JumsHelper.java] -->\n");
      out.write("        ");
      out.print( jh.chkinput(chkList) );
      out.write("\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    <form action=\"insert\" method=\"POST\">\n");
      out.write("        <!-- 再入力であることを表す値、REINPUTを送信 -->\n");
      out.write("        <input type=\"hidden\" name=\"mode\" value=\"REINPUT\">\n");
      out.write("        <!-- 登録画面に移動するボタン [insert.java] → [insert.jsp] -->\n");
      out.write("        <input type=\"submit\" name=\"no\" value=\"いいえ\" style=\"width:80px\">\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        <!-- \"トップページへ戻る\"ボタンを表示 -->\n");
      out.write("        ");
      out.print(jh.home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
