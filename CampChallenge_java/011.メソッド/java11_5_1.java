/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maruyamashunsuke
 */
public class java11_5_1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   String[] dataArray(int no){
        
        String data[] = new String[4];
        
        String id;          //ID
        String name;        //名前
        String birth;       //生年月日
        String adress;      //住所
        
        switch(no){
            case 10:
                
                id     = "10";
                name   = "古河";
                birth  = "1999/12/31";
                adress = "東京";
       
                data[0] = id;
                data[1] = name;
                data[2] = birth;
                data[3] = adress;
                
                break;
            
            case 20:
                
                id     = "20";
                name   = "織田";
                birth  = "1950/05/25";
                adress = "京都";
       
                data[0] = id;
                data[1] = name;
                data[2] = birth;
                data[3] = adress;
                
                break;
                
            case 30:
                
                id     = "30";
                name   = "島本";
                birth  = "1970/01/10";
                adress = "大阪";
       
                data[0] = id;
                data[1] = name;
                data[2] = birth;
                data[3] = adress;
                
                break;
        }
   
        return data;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        PrintWriter out = response.getWriter();
        
        String data[];
        
        int id = 20;
        
        data = dataArray(id);
           
        for(int i = 1; i < data.length; i++){
            out.print(data[i] + "<br>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
