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


public class challenge15cb {
    public static void main(String[] arg) throws FileNotFoundException, IOException{
        
        File fp = new File("test.txt");
        
        FileReader fr = new FileReader(fp);
                
        BufferedReader br = new BufferedReader(fr);
        
        System.out.println(br.readLine());
        
        br.close();
    }
}