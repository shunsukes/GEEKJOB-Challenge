/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.util.Date;
import java.io.*;

/**
 *
 * @author maruyamashunsuke
 */
public class challenge15_4_3 {

    public static void main(String[] args) {
        //Dateインスタンス生成
        Date now = new Date();
        //ログ用のFileを生成
        File log = new File("log.txt");
        try {
            //FileWriter生成
            FileWriter fw = new FileWriter(log, true);

            //Readerを生成
            FileReader fr = new FileReader(log);
            BufferedReader br = new BufferedReader(fr);
            //処理の開始時刻を書き込み
            fw.write(now + "処理開始<br>");
           
            //double型の変数を設定
            double a = -3.52;
            
            //-3.52を四捨五入
            fw.write(a + "「を」" + "四捨五入「" + Math.round(a) + "」");
            double b = Math.round(a);
            //int型に変換
            int c = (int) b;

            //－4の絶対値を求める
            fw.write("絶対値「" + Math.abs(c) + "」");
            int d = Math.abs(c);

            //4の平方根を求める
            fw.write("「" + d + "」の平方根は「" + Math.sqrt(d) + "」です。");
            //新たな変数に代入
            int e = (int) Math.sqrt(d);

            //4の2乗を求める
            fw.write("「" + d + "」の「" + e + "」乗は「" + Math.pow(d, e) + "」です。");

           
            //処理の終了を書き込み
            fw.write(now + "処理終了");
            fw.close();
            //Fileを表示
            System.out.print(br.readLine());
            br.close();
        } catch (Exception ex) {

        }
    }
}
