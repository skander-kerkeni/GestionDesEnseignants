/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.controller;

import iit.enseignants.entites.Grade;
import iit.enseignants.service.GradeService;
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
public class GradeController extends HttpServlet {

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
        GradeService gradeService=new GradeService();
        
        if(action.equalsIgnoreCase("ajouter"))
        {
       
        String libelle=request.getParameter("libelle");
        float prix_H_cours=Float.parseFloat(request.getParameter("prix_H_cours"));
        float prix_H_td=Float.parseFloat(request.getParameter("prix_H_td"));
        float prix_H_tp=Float.parseFloat(request.getParameter("prix_H_tp"));
        
      
        
        
        gradeService.addGrade( libelle,prix_H_cours,prix_H_td,prix_H_tp);
        
        RequestDispatcher dispatch = request.getRequestDispatcher("/result.jsp");
        request.setAttribute("resultat","Succes"); 
        dispatch.forward(request,response); 
        }else if (action.equalsIgnoreCase("displayGrade")) {
            List<Grade> list = gradeService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayGrade.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Grade e = gradeService.getGradeById(id);
            //Enseignants enseignant= enseignantService.updateEnseignant(e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/EditGrade.jsp");
            request.setAttribute("resultat", e);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit1")) {
            String libelle=request.getParameter("libelle");
             float prix_H_cours=Float.parseFloat(request.getParameter("prix_H_cours"));
        float prix_H_td=Float.parseFloat(request.getParameter("prix_H_td"));
        float prix_H_tp=Float.parseFloat(request.getParameter("prix_H_tp"));
            int id = Integer.parseInt(request.getParameter("id"));
            Grade e = gradeService.getGradeById(id);
            e.setLibelle(libelle);
            e.setPrix_H_cours(prix_H_cours);
            e.setPrix_H_td( prix_H_td);
            e.setPrix_H_tp(prix_H_tp);
            
            Grade grade = gradeService.updateGrade(e);
            List<Grade> list = gradeService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayGrade.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Grade e = gradeService.getGradeById(id);
            gradeService.deleteGrade(e);
            List<Grade> list = gradeService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayGrade.jsp");
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
