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
public class challenge18Run extends HttpServlet {

    void outPrint(ResultSet rs, PrintWriter out) throws SQLException{

        int code = rs.getInt("code");
        String name = rs.getString("name");
        int price = rs.getInt("price");

        out.print("商品コード：" + code + ", 商品名：" + name + ", 価格：" + price + "<br>");

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

        String url = "jdbc:mysql://localhost/Challenge2_db";
        String user = "shunsuke";
        String password = "sm631117";
        
        int code = Integer.parseInt(request.getParameter("code"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);

            String mode = request.getParameter("mode");
            int data = 0;

            switch(mode){
                case "add":
                    pstmt = conn.prepareStatement("INSERT INTO product_data (code, name, price) VALUES (?, ?, ?)");

                    pstmt.setInt(1, code);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, price);

                    data = pstmt.executeUpdate();
                    
                    rs = pstmt.executeQuery("SELECT * FROM product_data");
                    
                     if(rs.next() == false){
                        out.print("見つかりませんでした");
                     }
                    
                    while(rs.next()){
                        outPrint(rs, out);
                    }
            
                    break;
                    
                case "delete":
                    pstmt = conn.prepareStatement("DELETE FROM product_data WHERE code = ? && name = ? && price = ?");
                    
                    pstmt.setInt(1, code);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, price);
                    
                    data = pstmt.executeUpdate();
                    
                    rs = pstmt.executeQuery("SELECT * FROM product_data");
                    
                    if(rs.next() == false){
                        out.print("見つかりませんでした");
                    }                    
                    
                    while(rs.next()){
                        outPrint(rs, out);
                    }
                    
                    break;
                    
                case "update":
                    pstmt = conn.prepareStatement("UPDATE product_data SET name = ?, price = ? WHERE code = ?");
                    
                    pstmt.setString(1, name);
                    pstmt.setInt(2, price);
                    pstmt.setInt(3, code);
                    
                    data = pstmt.executeUpdate();
                    
                    rs = pstmt.executeQuery("SELECT * FROM product_data");

                    if(rs.next() == false){
                        out.print("見つかりませんでした");
                    }        
                    
                    while(rs.next()){
                        outPrint(rs, out);
                    }
                    
                    break;
                    
                case "and":
                    pstmt = conn.prepareStatement("SELECT * FROM product_data WHERE code = ? && name = ? && price = ?");
                    pstmt.setInt(1, code);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, price);

                    rs = pstmt.executeQuery();

                    if(rs.next() == false){
                        out.print("見つかりませんでした");
                    }        
                    
                    while(rs.next()){
                        outPrint(rs, out);
                    }
                    
                    break;

                case "or":
                    pstmt = conn.prepareStatement("SELECT * FROM product_data WHERE code = ? || name = ? || price = ?");
                    pstmt.setInt(1, code);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, price);

                    rs = pstmt.executeQuery();

                    if(rs.next() == false){
                        out.print("見つかりませんでした");
                    }        
                    
                    while(rs.next()){
                        outPrint(rs, out);
                    }

                    break;

                case "not":
                    pstmt = conn.prepareStatement("SELECT * FROM product_data WHERE NOT(code = ? || name = ? || price = ?)");
                    pstmt.setInt(1, code);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, price);

                    rs = pstmt.executeQuery();
                    
                    if(rs.next() == false){
                        out.print("見つかりませんでした");
                    }                            
                    
                    while(rs.next()){
                        outPrint(rs, out);
                    }

                    break;
            }
            
            pstmt.close(); 
            rs.close();
            
        } catch (SQLException e_sql) {
            out.print("接続時にエラーが発生しました1：" + e_sql.toString());
        } catch (Exception e) {
            out.print("接続時にエラーが発生しました2：" + e.toString());
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
