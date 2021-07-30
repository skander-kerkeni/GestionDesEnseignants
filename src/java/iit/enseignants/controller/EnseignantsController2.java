/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.controller;

import iit.enseignants.entites.Departement;
import iit.enseignants.entites.Enseignants;
import iit.enseignants.entites.Grade;
import iit.enseignants.entites.Matiere;
import iit.enseignants.entites.Niveau;
import iit.enseignants.service.DepartementService;
import iit.enseignants.service.EnseignantsService;
import iit.enseignants.service.GradeService;
import iit.enseignants.service.MatiereService;
import iit.enseignants.service.NiveauService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.ForEach;

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

        String action = request.getParameter("action");
        EnseignantsService enseignantService = new EnseignantsService();

        if (action.equalsIgnoreCase("ajouter")) {
            int cin = Integer.parseInt(request.getParameter("cin"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String adress = request.getParameter("adress");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String grade = request.getParameter("grade");
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
            enseignantService.addEnseignant(cin, nom, prenom, adress, email, phone, login, password,grade);

            List<Enseignants> list = enseignantService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayEns.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("displayEnseignant")) {
            List<Enseignants> list = enseignantService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayEns.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Enseignants e = enseignantService.getEnseignantById(id);
            //Enseignants enseignant= enseignantService.updateEnseignant(e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/EditEnseignant.jsp");
            request.setAttribute("resultat", e);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit1")) {
            int cin = Integer.parseInt(request.getParameter("cin"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String adress = request.getParameter("adress");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("id"));

            Enseignants e = enseignantService.getEnseignantById(id);
            e.setAdress(adress);
            e.setCin(cin);
            e.setEmail(email);
            e.setNom(nom);
            e.setPrenom(prenom);
            e.setPhone(phone);
            e.setLogin(login);
            e.setPassword(password);
            Enseignants enseignant = enseignantService.updateEnseignant(e);
            List<Enseignants> list = enseignantService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayEns.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Enseignants e = enseignantService.getEnseignantById(id);
            enseignantService.deleteEnseignant(e);
            List<Enseignants> list = enseignantService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayEns.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }
         else if (action.equalsIgnoreCase("verifier")) {
             String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
          Enseignants e = enseignantService.verification(login,password);
          String nom= e.getPrenom()+e.getNom();
           DepartementService departementService=new DepartementService();
          Departement d = departementService.veritfication(nom);
         
         if(e != null && d!= null){
                  response.setContentType("text/html;charset=UTF-8");
         session.setAttribute("login", login);
         session.setAttribute("password", password);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        response.setHeader("refresh", "0;./SeanceController?action=displaySeancedep&id="+d.getId_departement()+"");
        }}
        else if(e != null && d == null){
                  response.setContentType("text/html;charset=UTF-8");
         session.setAttribute("login", login);
         session.setAttribute("password", password);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        response.setHeader("refresh", "0;./SeanceController?action=displaySeanceens&nom="+e.getPrenom()+e.getNom()+"");
        }
       
         
       
       
    }else{
            response.setHeader("refresh", "0;./login.jsp");}
             

        }
        else if (action.equalsIgnoreCase("display")) {
             
              GradeService GradeService=new GradeService();
            List<Grade> list = GradeService.displayAll();
            
            RequestDispatcher dispatch = request.getRequestDispatcher("/AddEnseignant.jsp");
            request.setAttribute("resultat", list);
            
            dispatch.forward(request, response);
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
