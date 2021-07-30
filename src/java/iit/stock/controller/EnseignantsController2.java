/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.stock.controller;

import iit.stock.service.EnseignantsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmed.benarab
 */
//@WebServlet(name="EnseignantsController" urlPatterns={"/EnseignantsController"} ) 
//@WebServlet(name="EnseignantsController")
public class EnseignantsController2 extends HttpServlet {

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
       
        String action=request.getParameter("action");
        EnseignantsService enseignantService=new EnseignantsService();
        
        
        if(action.equalsIgnoreCase("ajouter"))
        {
        int cin=Integer.parseInt(request.getParameter("cin"));
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String adress=request.getParameter("adress");
        int phone=Integer.parseInt(request.getParameter("phone"));
        String email=request.getParameter("email");
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        /*try (PrintWriter out = response.getWriter()) {
              out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authentification</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+cin+"</h1>");
        
            //out.println("<h1>Servlet Authentification at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
        
        }*/
        enseignantService.addEnseignant(cin, nom, prenom, adress, email, phone, login, password);
        
        
        RequestDispatcher dispatch = request.getRequestDispatcher("/result.jsp");
        request.setAttribute("resultat","Succes"); 
        dispatch.forward(request,response); 
        }
        else if(action.equalsIgnoreCase("approvisionner"))
        {
            
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
