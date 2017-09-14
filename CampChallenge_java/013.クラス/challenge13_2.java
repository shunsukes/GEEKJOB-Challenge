/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

/**
 *
 * @author maruyamashunsuke
 */

class Human13b {

    public String name = "";
    public Integer age = 0;

    public void setHuman13b(String n, int a) {

        this.name = n;
        this.age = a;

        printHuman13b(n, a);
    }

    public void printHuman13b(String n, int a) {

        System.out.println("【クリア前】");

        System.out.println(n);
        System.out.println(a);

    }
}

class ClearHuman extends Human13b{

    public void clear() {
        this.name = null;
        this.age = null;

        System.out.println("【クリア後】");

        System.out.println(this.name);
        System.out.println(this.age);
    }
}

public class challenge13_2 {

    public static void main(String[] args) {

        ClearHuman soeda = new ClearHuman();

        soeda.setHuman13b("添田亮司", 34);

        soeda.age = 30;

        soeda.clear();
    }
}
