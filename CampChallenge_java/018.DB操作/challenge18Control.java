/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


/**
 *
 * @author maruyamashunsuke
 */
public class challenge18Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        String un;
        
        if(session == null || session.getAttribute("username") == null){
            return;
        } else {
            un = (String) session.getAttribute("username");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet java19_3_13_control</title>");            
        out.println("</head>");
        out.println("<body>");

        out.println("ようこそ！" + un + "さん");
        out.println("<form action=\"java19_3_13_logoutCheck\" method=\"get\">");
        out.println("<input type=\"submit\" name=\"logout\" value=\"ログアウト\">");
        out.println("<p/>");
        out.println("</form>");
        out.println("<form action=\"java19_3_13_list\" method=\"get\">");
        out.println("<input type=\"submit\" name=\"list\" value=\"商品一覧\">");
        out.println("</form>");
        
        out.println("<form target=\"_blank\" action=\"java19_3_13_run\" method=\"post\">");
        out.println("<p>コード：<input type=\"text\" name=\"code\"></p>");
        out.println("<p>商品名：<input type=\"text\" name=\"name\"></p>");
        out.println("<p>価格　：<input type=\"number\" name=\"price\" min = 0></p>");
        out.println("<select name=\"mode\">");
        out.println("<option value=\"add\">追加</option>");
        out.println("<option value=\"delete\">削除</option>");
        out.println("<option value=\"update\">更新</option>");
        out.println("<optgroup label=\"検索\">");
        out.println("<option value=\"and\">├ AND検索</option>");
        out.println("<option value=\"or\">├ OR検索</option>");
        out.println("<option value=\"not\">└ NOT検索</option>");
        out.println("</select>");
        out.println("<input type=\"submit\" name=\"run\" value=\"実行\">");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
