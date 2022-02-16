/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class ShoppingListServlet extends HttpServlet {
    //ArrayList<Useritems> useritems = new ArrayList<>();

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
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String action = request.getParameter("action");
        
        //action != null avoid for NullPointerException error
        if(action != null && action.equals("logout")){
            session.invalidate();
            request.setAttribute("message", "User has logouted, register again!");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
        if(username != null && !username.equals("")){
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
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
        String username = null;
        Userlist ul = null;
        String msg = null;
        String item = null;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if(action != "" && action != null && action.equals("register")){
            username = request.getParameter("username");
            if(username.equals("null") || username.equals("")){
                request.setAttribute("message", "Please enter a user name!");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }else{
                ul = new Userlist(username); //initialize Userlist object
                ul.setItems(new ArrayList<String>());//initialize private field attributes
                session.setAttribute("user", ul);
                session.setAttribute("username", username);//store in session
                request.setAttribute("user", ul);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
            }
        }
        
        if(action != "" && action != null && action.equals("add")){
            ul = (Userlist)session.getAttribute("user");
            item = request.getParameter("item");
            if(item!=null && item !="" && !item.equals("null")){
                ul.addItems(item);
                session.setAttribute("user", ul);
                request.setAttribute("user", ul);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
            }else{
                request.setAttribute("msg", "Please enter a Shopping Item!");
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);  
            }
        }
        
        if(action != "" && action != null && action.equals("delete")){
            ul = (Userlist)session.getAttribute("user");
            item = request.getParameter("orderitem");
            if(item!=null && item !=""){
                ul.removeItems(item);
                session.setAttribute("user", ul);
                request.setAttribute("user", ul);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
            }else{
                request.setAttribute("msg", "Please select a Shopping Item!");
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);  
            }
        }
    }
}
