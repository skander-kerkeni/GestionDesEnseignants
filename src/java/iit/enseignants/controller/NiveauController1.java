/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.controller;

import iit.enseignants.entites.Niveau;
import iit.enseignants.service.NiveauService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Lenovo
 */
public class NiveauController1 extends HttpServlet {

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
        NiveauService niveauService=new NiveauService();
        
        
        if(action.equalsIgnoreCase("ajouter"))
        {
       
        String libelle=request.getParameter("libelle");
      
        
        
        niveauService.addNiveau( libelle);
        
        niveauService.addNiveau(libelle);

            List<Niveau> list = niveauService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayNiveau.jsp");
            request.setAttribute("resultat", list);
        }else if (action.equalsIgnoreCase("displayNiveau")) {
            List<Niveau> list = niveauService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayNiveau.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Niveau e = niveauService.getNiveauById(id);
            //Enseignants enseignant= enseignantService.updateEnseignant(e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/EditNiveau.jsp");
            request.setAttribute("resultat", e);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit1")) {
            String libelle=request.getParameter("libelle");
            int id = Integer.parseInt(request.getParameter("id"));
            Niveau e = niveauService.getNiveauById(id);
            e.setLibelle(libelle);
            
            Niveau niveau = niveauService.updateNiveau(e);
            List<Niveau> list = niveauService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayNiveau.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Niveau e = niveauService.getNiveauById(id);
            niveauService.deleteNiveau(e);
            List<Niveau> list = niveauService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayNiveau.jsp");
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
