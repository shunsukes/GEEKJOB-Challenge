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
public class java11_5_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   String[][] dataArray(int no){
        
        String data[][] = new String[3][4];
        
        String id;
        String name;
        String birth;
        String adress;
        
        switch(no){
            case 0:
                
                id     = "10";
                name   = "古河";
                birth  = "1999/12/31";
                adress = null;
       
                data[0][0] = id;
                data[0][1] = name;
                data[0][2] = birth;
                data[0][3] = adress;
                
                break;
            
            case 1:
                
                id     = "20";
                name   = "織田";
                birth  = "1950/05/25";
                adress = "京都";
       
                data[1][0] = id;
                data[1][1] = name;
                data[1][2] = birth;
                data[1][3] = adress;
                
                break;
                
            case 2:
                
                id     = "30";
                name   = "島本";
                birth  = "1970/01/10";
                adress = "大阪";
       
                data[2][0] = id;
                data[2][1] = name;
                data[2][2] = birth;
                data[2][3] = adress;
                
                break;
        }
   
        return data;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        PrintWriter out = response.getWriter();
        
        String data[][];
        
        for(int i = 0; i < 3; i++){
            
            data = dataArray(i);
        
            for(int j = 1; j < data[i].length ; j++){
            
                if(data[i][j] == null){
                    continue;
                }
            
                out.print(data[i][j] + "<br>");
            }
            
            out.print("<br>");
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
