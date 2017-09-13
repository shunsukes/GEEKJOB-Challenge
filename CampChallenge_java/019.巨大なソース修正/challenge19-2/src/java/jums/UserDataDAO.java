package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
        
    // インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){ return new UserDataDAO(); }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        
        Connection conn = null;
        
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            
            // INSERT文の準備
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            // INSERT文中の「?」に仕様する値を設定しSQLを完成
            pstmt.setString(1, ud.getName());
            pstmt.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));    // 指定のタイムスタンプ値からSQL格納用のDATE型に変更
            pstmt.setString(3, ud.getTell());
            pstmt.setInt(4, ud.getType());
            pstmt.setString(5, ud.getComment());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            // INSERT文を実行
            pstmt.executeUpdate();
            System.out.println("insert completed");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            // データベース切断
            if(conn != null) { conn.close(); }
        }
    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public List<UserDataDTO> search(UserDataDTO ud) throws SQLException {
        
        Connection conn = null;
        
        try {
            // // データベースへ接続
            conn = DBManager.getConnection();
            
            // SELECT文の準備
            String sql = "SELECT * FROM user_t ";
            boolean flag = false;

            // 検索条件に"名前"が含まれている場合
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
            }
            // 検索条件に"生年"が含まれている場合
            if (ud.getBirthday()!=null) {
                // 検索条件に"名前"が含まれていない場合
                if(!flag) {
                    sql += " WHERE birthday like ?";
                    flag = true;
                // 検索条件に"名前"が含まれている場合
                } else { sql += " AND birthday like ?"; }
            }
            // 検索条件に"種別"が含まれている場合
            if (ud.getType()!=0) {
                // 検索条件に"名前"or"生年"が含まれていない場合
                if(!flag) { sql += " WHERE type like ?"; }
                // 検索条件に"名前"or"生年"が含まれている場合
                else { sql += " AND type like ?"; }
            }
            
            ResultSet rs = null;
            
            // 検索条件が何も入力されていないときは全件表示
            // 検索条件なしの場合は全件表示　"SELECT * FROM user_t"
            if(ud.getName().equals("") && ud.getBirthday()==null && ud.getType()==0){
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
            // 検索条件ありの場合
            } else {
                // 3つの検索条件のうち、1つでも未入力だとエラーが出る
                PreparedStatement pstmt = null;
                
                // 検索条件：名前＋生年＋種別"SELECT * FROM user_t WHERE name like ? AND birthday like ?AND type like ?"
                if(!ud.getName().equals("") && ud.getBirthday()!=null && ud.getType()!=0){
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%"+ud.getName()+"%");
                    pstmt.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    pstmt.setInt(3, ud.getType());
                // 検索条件：名前＋生年　"SELECT * FROM user_t WHERE name like ? AND birthday like ?"
                } else if(!ud.getName().equals("") && ud.getBirthday()!=null) {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%"+ud.getName()+"%");
                    pstmt.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                // 検索条件：名前＋種別　"SELECT * FROM user_t WHERE name like ? AND type like ?"
                } else if(!ud.getName().equals("") && ud.getType()!=0) {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%"+ud.getName()+"%");
                    pstmt.setInt(2, ud.getType());
                // 検索条件：生年＋種別　"SELECT * FROM user_t WHERE birthday like ? AND type like ?"
                } else if(ud.getBirthday()!=null && ud.getType()!=0) {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    pstmt.setInt(2, ud.getType());
                // 検索条件：名前　"SELECT * FROM user_t WHERE name like ?"
                } else if(!ud.getName().equals("")) { 
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%"+ud.getName()+"%");
                    
                // 検索条件：生年　"SELECT * FROM user_t WHERE birthday like ?"
                } else if(ud.getBirthday()!=null) { 
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                    
                // 検索条件：種別　"SELECT * FROM user_t WHERE type like ?"
                } else if(ud.getType()!=0) { 
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, ud.getType()); 
                }

                // SELECT文を実行
                rs = pstmt.executeQuery();
            }
            
            // 修正④　検索結果の画面で複数件ヒットしても、1件しか表示されない
            // 検索結果を格納するためにArrayListを用意
            List<UserDataDTO> udd = new ArrayList<UserDataDTO>();
            
            // ヒットした件数分ループさせ、uddに格納
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                
                resultUd.setUserID(rs.getInt("userID"));
                resultUd.setName(rs.getString("name"));
                resultUd.setBirthday(rs.getDate("birthday"));
                resultUd.setTell(rs.getString("tell"));
                resultUd.setType(rs.getInt("type"));
                resultUd.setComment(rs.getString("comment"));
                resultUd.setNewDate(rs.getTimestamp("newDate"));
                
                udd.add(resultUd);
            }

            System.out.println("search completed");

            return udd;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            // データベースを切断
            if(conn != null) { conn.close(); }
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        
        Connection conn = null;
        
        try{
            conn = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            pstmt.setInt(1, ud.getUserID());
            
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if(conn != null){ conn.close(); }
        }
    }
    
    public void update(UserDataDTO ud) throws SQLException{
        
        Connection conn = null;
        
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            
            // UPDATE文の準備
            String sql = "UPDATE user_t SET name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? WHERE userID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // UPDATE文中の「?」に仕様する値を設定しSQLを完成
            pstmt.setString(1, ud.getName());
            pstmt.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));    // 指定のタイムスタンプ値からSQL格納用のDATE型に変更
            pstmt.setString(3, ud.getTell());
            pstmt.setInt(4, ud.getType());
            pstmt.setString(5, ud.getComment());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(7, ud.getUserID());
            // UPDATE文を実行
            pstmt.executeUpdate();
            System.out.println("update completed");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            // データベース切断
            if(conn != null) { conn.close(); }
        }
    }
    
    public void delete(UserDataDTO ud) throws SQLException{
        
        Connection conn = null;
        
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            // DELETE文の準備
            String sql = "DELETE FROM user_t WHERE userID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // DELETE文中の「?」に仕様する値を設定しSQLを完成
            pstmt.setInt(1, ud.getUserID());
            //DELETE文を実行
            pstmt.executeUpdate();
            System.out.println("delete completed");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            // データベース切断
            if(conn != null) { conn.close(); }
        }
    }
}
