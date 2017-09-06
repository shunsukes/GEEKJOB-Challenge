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

public class challenge18cl extends HttpServlet {
    
    void outPrint(ResultSet rs, PrintWriter out) throws SQLException{
        
        int profilesID_p = rs.getInt("profilesID");
        String name_p = rs.getString("name");
        String tell_p = rs.getString("tell");
        int age_p = rs.getInt("age");
        String birthday_p = rs.getString("birthday");

        out.print("プロフィールID：" + profilesID_p + ", 名前：" + name_p
                + ", 電話番号：" + tell_p + ", 年齢：" + age_p + ", 誕生日：" + birthday_p + "<br>");
        
    }
    
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

        String url = "jdbc:mysql://localhost/GEEKJOB_db";
        String user = "hori";
        String password = "geekjob@hori";
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);

            String search = request.getParameter("search");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String birthday = request.getParameter("birthday");

            switch (search) {
                case "and":
                    pstmt = conn.prepareStatement("SELECT * FROM profiles WHERE name LIKE ? && age = ? && birthday = ?");
                    pstmt.setString(1, "%" + name + "%");
                    pstmt.setInt(2, age);
                    pstmt.setString(3, birthday);

                    rs = pstmt.executeQuery();
                    
                    while(rs.next()){
                        outPrint(rs, out);
                        out.print("<br");
                    }
                    
                    break;

                case "or":
                    pstmt = conn.prepareStatement("SELECT * FROM profiles WHERE name LIKE ? || age = ? || birthday = ?");
                    pstmt.setString(1, "%" + name + "%");
                    pstmt.setInt(2, age);
                    pstmt.setString(3, birthday);

                    rs = pstmt.executeQuery();
                    
                    while(rs.next()){
                        outPrint(rs, out);
                        out.print("<br");
                    }

                    break;

                case "not":
                    pstmt = conn.prepareStatement("SELECT * FROM profiles WHERE NOT(name LIKE ? || age = ? || birthday = ?)");
                    pstmt.setString(1, "%" + name + "%");
                    pstmt.setInt(2, age);
                    pstmt.setString(3, birthday);

                    rs = pstmt.executeQuery();
                    
                    while(rs.next()){
                        outPrint(rs, out);
                        out.print("<br");
                    }

                    break;
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
