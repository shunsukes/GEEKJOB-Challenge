package jums;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */

//　UserDataDTOがJavaBeansのルールを満たしていない（直列化可能になっていない）
public class UserDataDTO implements Serializable {
    
    private int userID;         // ユーザーID
    private String name;        // 名前
    private Date birthday;      // 生年月日
    private String tell;        // 電話番号
    private int type;           // 種別
    private String comment;     // 自己紹介文
    private Timestamp newDate;  // 登録日時
    
    // コンストラクタ
    public UserDataDTO() {}
   
    // getter setter
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    
    public Date getBirthday(){ return birthday; }
    public void setBirthday(Date birthday){ this.birthday = birthday; }
    
    public String getTell(){ return tell; }
    public void setTell(String tell){ this.tell = tell; }
    
    public int getType(){ return type; }
    public void setType(int type){ this.type = type; }
    
    public String getComment(){ return comment; }
    public void setComment(String comment){ this.comment = comment; }
    
    public Timestamp getNewDate() { return newDate; }
    public void setNewDate(Timestamp newDate) { this.newDate = newDate; }
}
