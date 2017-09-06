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

import java.sql.*;

/**
 *
 * @author maruyamashunsuke
 */
public class challenge18ci extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost/Challenge2_db";
        String user = "shunsuke";
        String password = "sm631117";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);

            pstmt = conn.prepareStatement("INSERT INTO profiles (profilesID, name, tell, age, birthday) VALUES (?, ?, ?, ?, ?)");

            pstmt.setInt(1, Integer.parseInt(request.getParameter("profilesID")));
            pstmt.setString(2, request.getParameter("name"));
            pstmt.setString(3, request.getParameter("tell"));
            pstmt.setInt(4, Integer.parseInt(request.getParameter("age")));
            pstmt.setString(5, request.getParameter("birthday"));
            int num = pstmt.executeUpdate();

            rs = pstmt.executeQuery("SELECT * FROM profiles");
    
            while (rs.next()) {
                int profilesID = rs.getInt("profilesID");
                String name = rs.getString("name");
                String tell = rs.getString("tell");
                int age = rs.getInt("age");
                String birthday = rs.getString("birthday");

                out.print("プロフィールID：" + profilesID + ", 名前：" + name
                        + ", 電話番号：" + tell + ", 年齢：" + age + ", 誕生日：" + birthday + "<br>");
            }

            pstmt.close();
            rs.close();

        } catch (SQLException e_sql) {
            out.print("接続時にエラーが発生しました：" + e_sql.toString());
        } catch (Exception e) {
            out.print("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e_con) {
                    out.print(e_con.getMessage());
                }
            }
        }
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
