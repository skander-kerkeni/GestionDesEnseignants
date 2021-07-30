/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.controller;

import iit.enseignants.entites.Departement;
import iit.enseignants.entites.Enseignants;
import iit.enseignants.entites.Matiere;
import iit.enseignants.entites.Niveau;
import iit.enseignants.service.DepartementService;
import iit.enseignants.service.EnseignantsService;
import iit.enseignants.service.MatiereService;
import iit.enseignants.service.NiveauService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class MatiereController extends HttpServlet {

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
        MatiereService matiereService=new MatiereService();
        
        if(action.equalsIgnoreCase("ajouter"))
        {
       
        String libelle=request.getParameter("libelle");
        String tp=request.getParameter("tp");
        String td=request.getParameter("td");
        String cours=request.getParameter("cours");
        String departement=request.getParameter("departement");
        String niveau=request.getParameter("niveau");
        String enseignant=request.getParameter("enseignant");
        
        
        
        matiereService.addMatiere( libelle, tp, td,cours,departement,niveau,enseignant);
        
        List<Matiere> list = matiereService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayMatiere.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        dispatch.forward(request,response); 
        }else if (action.equalsIgnoreCase("displayMatiere")) {
            List<Matiere> list = matiereService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayMatiere.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Matiere e = matiereService.getMatiereById(id);
            //Enseignants enseignant= enseignantService.updateEnseignant(e);
             EnseignantsService enseignantService = new EnseignantsService();
              NiveauService niveauService=new NiveauService();
              DepartementService departementService=new DepartementService();
            List<Enseignants> list = enseignantService.displayAll();
            List<Niveau> list2 = niveauService.displayAll();
              List<Departement> list1 = departementService.displayAll();
            request.setAttribute("resultat", list);
            request.setAttribute("resultat1", list1);
            request.setAttribute("resultat2", list2);
             request.setAttribute("resultat3", e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/EditMatiere.jsp");
           
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit1")) {
            String libelle=request.getParameter("libelle");
               String tp=request.getParameter("tp");
        String td=request.getParameter("td");
        String cours=request.getParameter("cours");
            String departement=request.getParameter("departement");
        String niveau=request.getParameter("niveau");
        String enseignant=request.getParameter("enseignant");
            int id = Integer.parseInt(request.getParameter("id"));
            Matiere e = matiereService.getMatiereById(id);
            e.setLibelle(libelle);
            e.setTp(tp);
            e.setTd(td);
            e.setCours(cours);
            e.setDepartement(departement);
            e.setNiveau(niveau);
            e.setEnseignant(enseignant);
            
            Matiere matiere = matiereService.updateMatiere(e);
            List<Matiere> list = matiereService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayMatiere.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Matiere e = matiereService.getMatiereById(id);
            matiereService.deleteMatiere(e);
            List<Matiere> list = matiereService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayMatiere.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }else if (action.equalsIgnoreCase("display")) {
             EnseignantsService enseignantService = new EnseignantsService();
              NiveauService niveauService=new NiveauService();
              DepartementService departementService=new DepartementService();
            List<Enseignants> list = enseignantService.displayAll();
            List<Niveau> list2 = niveauService.displayAll();
              List<Departement> list1 = departementService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/AddMatiere.jsp");
            request.setAttribute("resultat", list);
            request.setAttribute("resultat1", list1);
            request.setAttribute("resultat2", list2);
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
