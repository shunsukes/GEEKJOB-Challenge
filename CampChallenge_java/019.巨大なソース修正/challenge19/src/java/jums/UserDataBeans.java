/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

/**
 *
 * @author maruyamashunsuke
 */
public class UserDataBeans implements Serializable {

    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private int type;
    private String comment;
    
    public UserDataBeans() {
        this.name    = "";
        this.year    = 0;
        this.month   = 0;
        this.day     = 0;
        this.tell    = "";
        this.type    = 0;
        this.comment = "";
    }
    
    public String getName() { return name; }
    public void setName(String name) {
        // nullチェック。nullの場合は空文字を代入
        if(name.trim().length() == 0) { this.name = ""; }
        else { this.name = name; }
    }

    public int getYear() { return year; }
    public void setYear(String year) {
        if(year.equals("")) { this.year = 0; }
        else { this.year = Integer.parseInt(year); }
    }
    
    public int getMonth() { return month; }
    public void setMonth(String month) {
        if(month.equals("")) { this.month = 0; }
        else { this.month = Integer.parseInt(month); }
    }

    public int getDay() { return day; }
    public void setDay(String day) {
        if(day.equals("")) { this.day = 0; }
        else { this.day = Integer.parseInt(day); }
    }
    
    public String getTell() { return tell; }
    public void setTell(String tell) {
        if(tell.trim().length() == 0) { this.tell = ""; }
        else { this.tell = tell; }
    }
    
    public int getType() { return type; }
    public void setType(String type) {
        if(type == null){ this.type = 0; }
        else { this.type = Integer.parseInt(type); }
    }
    
    public String getComment() { return comment; }
    public void setComment(String comment) {
        if(comment.trim().length() == 0) { this.comment = ""; }
        else { this.comment = comment; }
    }
}
