/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author maruyamashunsuke
 */
public class challenge18cb {
    public static void main(String[] arg){
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        String url = "jdbc:mysql://localhost/Challenge2_db";
        String user = "shunsuke";
        String password = "sm631117";
                
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);

            pstmt = conn.prepareStatement("INSERT INTO profiles (profilesID, name, tell, age, birthday) VALUES (?, ?, ?, ?, ?)");
            
            pstmt.setInt(1, 6);
            pstmt.setString(2, "山田 太郎");
            pstmt.setString(3, "000-0000-0000");
            pstmt.setInt(4, 20);
            pstmt.setString(5, "1990-01-01");
            int num = pstmt.executeUpdate();
            
            pstmt.setInt(1, 7);
            pstmt.setString(2, "丸山　俊介");
            pstmt.setString(3, "000-0000-0000");
            pstmt.setInt(4, 22);
            pstmt.setString(5, "1988-11-17");  
            num = pstmt.executeUpdate();
            
            pstmt.close();
            
        } catch(SQLException e_sql) {
                System.out.println("接続時にエラーが発生しました：" + e_sql.toString());
        } catch(Exception e) {
                System.out.println("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if(conn != null) {
                try{
                    conn.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
        }    
    }
}