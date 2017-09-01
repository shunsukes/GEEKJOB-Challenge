/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mypackage.sample;

import java.io.*;

/**
 *
 * @author maruyamashunsuke
 */

public class challenge15ca {
    public static void main(String[] arg) throws IOException{
        
        File fp = new File("test.txt");
        
        FileWriter fw = new FileWriter(fp);
        
        fw.write("丸山俊介です。よろしくお願いします。");
        
        fw.close();
    }
}
