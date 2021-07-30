/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.controller;

import iit.enseignants.entites.Departement;
import iit.enseignants.entites.Enseignants;
import iit.enseignants.entites.Matiere;
import iit.enseignants.service.DepartementService;
import iit.enseignants.service.EnseignantsService;
import iit.enseignants.service.MatiereService;
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
public class DepartementController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
      
        String action=request.getParameter("action");
        DepartementService departementService=new DepartementService();
        
        
        if(action.equalsIgnoreCase("ajouter"))
        {
        String lib=request.getParameter("libelle");
      
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
        departementService.addDepartement(lib,null);
        List<Departement> list = departementService.displayAll();
        RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayDepartement.jsp"); 
         request.setAttribute("resultat", list);
        dispatch.forward(request,response); 
        }
        else if (action.equalsIgnoreCase("displayDepartement")) {
            List<Departement> list = departementService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayDepartement.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Departement e = departementService.getDepartementById(id);
            //Enseignants enseignant= enseignantService.updateEnseignant(e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/EditDepartement.jsp");
            request.setAttribute("resultat", e);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit1")) {
            String libelle=request.getParameter("libelle");
            int id = Integer.parseInt(request.getParameter("id"));
            Departement e = departementService.getDepartementById(id);
            e.setLibelle_departement(libelle);
            Departement departement = departementService.updateDepartement(e);
            List<Departement> list = departementService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayDepartement.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Departement e = departementService.getDepartementById(id);
            departementService.deleteDepartement(e);
            List<Departement> list = departementService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayDepartement.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }
        else if (action.equalsIgnoreCase("editchef")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Departement e = departementService.getDepartementById(id);
            EnseignantsService enseignantService = new EnseignantsService();
            List<Enseignants> list = enseignantService.displayAll();
            request.setAttribute("resultat", list);
            request.setAttribute("resultat1", e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/editChef.jsp");
            
            dispatch.forward(request, response);

        }
        else if (action.equalsIgnoreCase("editchef1")) {
            String enseignant = request.getParameter("enseignant");
            int id = Integer.parseInt(request.getParameter("id"));
            Departement e = departementService.getDepartementById(id);
            e.setChef(enseignant);
            Departement departement = departementService.updateDepartementchef(e);
            List<Departement> list = departementService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplayDepartement.jsp");
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
