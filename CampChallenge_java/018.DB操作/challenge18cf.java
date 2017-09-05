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
public class challenge18cf{
    public static void main(String[] arg){
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String url = "jdbc:mysql://localhost/Challenge2_db";
        String user = "shunsuke";
        String password = "sm631117";
                
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);

            pstmt = conn.prepareStatement("DELETE FROM profiles WHERE profilesID = ?");
            
                        pstmt.setInt(1, 6);
            int num = pstmt.executeUpdate();
            
            pstmt.setInt(1, 7);
            num = pstmt.executeUpdate();            
            
            stmt = conn.createStatement();
            rs =  stmt.executeQuery("SELECT * FROM profiles");
                
            while(rs.next()){
                int profilesID = rs.getInt("profilesID");
                String name = rs.getString("name");
                String tell = rs.getString("tell");
                int age = rs.getInt("age");
                String birthday = rs.getString("birthday");
                
                System.out.println("プロフィールID：" + profilesID + ", 名前：" + name
                        + ", 電話番号：" + tell + ", 年齢" + age + ", 誕生日" + birthday);
            }
            
            pstmt.close();
            rs.close();
                        
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
