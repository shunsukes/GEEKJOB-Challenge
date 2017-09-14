package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;
import jums.UserDataDTO;
import java.util.Calendar;

public final class updateresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    JumsHelper jh = JumsHelper.getInstance();
    // セッション開始
    HttpSession hs = request.getSession();
    // 1件のユーザー情報が格納されたセッションデータを取得 [ResultDetail.javaより]
    UserDataDTO udt = (UserDataDTO) request.getAttribute("updateData");
    // 誕生日を生年・月・日に分けるために、カレンダー型に変換　c.get(Calendar.YEAR)で生年取得
    Calendar c = Calendar.getInstance();
    c.setTime(udt.getBirthday());

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS更新結果画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <h1>変更結果</h1><br>\n");
      out.write("    名前:");
      out.print( udt.getName() );
      out.write(" <br>\n");
      out.write("    生年月日:");
      out.print( c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1)  + "月" + c.get(Calendar.DAY_OF_MONTH) + "日");
      out.write("<br>\n");
      out.write("    種別:");
      out.print( jh.exTypenum(udt.getType()) );
      out.write("<br>\n");
      out.write("    電話番号:");
      out.print( udt.getTell() );
      out.write("<br>\n");
      out.write("    自己紹介文:");
      out.print( udt.getComment() );
      out.write("<br><br>\n");
      out.write("    以上の内容で登録しました。<br><br>\n");
      out.write("    <form action=\"ResultDetail\" method=\"POST\">\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( udt.getUserID() );
      out.write("\">\n");
      out.write("        <input type=\"submit\" name=\"NO\" value=\"詳細画面へ戻る\">\n");
      out.write("    </form>\n");
      out.write("    <br>\n");
      out.write("    <!-- \"トップページへ戻る\"ボタンを表示 -->\n");
      out.write("    ");
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
