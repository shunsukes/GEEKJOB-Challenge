package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // セッション開始
        HttpSession session = request.getSession();
        
        try{
            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            
            // アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }
            
            // フォームからの入力を取得して、JavaBeans[UserDataBeans.java]に格納
            UserDataBeans udb_update = new UserDataBeans();
            udb_update.setName(request.getParameter("name"));
            udb_update.setYear(request.getParameter("year"));
            udb_update.setMonth(request.getParameter("month"));
            udb_update.setDay(request.getParameter("day"));
            udb_update.setType(request.getParameter("type"));
            udb_update.setTell(request.getParameter("tell"));
            udb_update.setComment(request.getParameter("comment"));
            
            // ユーザー情報群をセッションに格納
            session.setAttribute("udb_update", udb_update);
            System.out.println("Session updated!!");

            // DB専用のパラメータに変換 [UserDataDTO.java]
            UserDataDTO updateData = new UserDataDTO();
            udb_update.UD2DTOMapping(updateData);
            
            updateData.setUserID(Integer.parseInt(request.getParameter("id")));
            
            // DBへデータの更新 [UserDataDAO.java]
            UserDataDAO .getInstance().update(updateData);
            
            // 結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            request.setAttribute("updateData", updateData);
            
            // 更新-完了画面[updateresult.jsp]にフォワード
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response); 
            
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
