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
public class challenge18ca {
    public static void main(String[] arg){
        
        Connection db_con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            db_con = DriverManager.getConnection("jdbc:mysql://localhost/Challenge2_db", "shunsukes", "sm631117");
            System.out.println("データベースに接続しました");
            
            db_con.close();
 
        } catch(SQLException e_sql) {
                System.out.println("接続時にエラーが発生しました：" + e_sql.toString());
        } catch(Exception e) {
                System.out.println("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if(db_con != null) {
                try{
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
        }    
    }
}
