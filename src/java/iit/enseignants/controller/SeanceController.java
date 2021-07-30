/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iit.enseignants.controller;

import iit.enseignants.entites.Departement;
import iit.enseignants.entites.Enseignants;
import iit.enseignants.entites.Matiere;
import iit.enseignants.entites.Seance;
import iit.enseignants.service.DepartementService;
import iit.enseignants.service.EnseignantsService;
import iit.enseignants.service.MatiereService;
import iit.enseignants.service.SeanceService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
public class SeanceController extends HttpServlet {

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
        SeanceService seanceService=new SeanceService();
        HttpSession session1 = request.getSession();
        
        if(action.equalsIgnoreCase("ajouter"))
        {
       
        String date=request.getParameter("date");
        String heure_debut=request.getParameter("heure_debut");
        String duree=request.getParameter("duree");
         String methode=request.getParameter("methode");
        //int  validee=Integer.parseInt(request.getParameter("validee"));
        String  type=request.getParameter("type");
         String enseignant = request.getParameter("enseignant");
         String matiere = request.getParameter("matiere");
       
        
        seanceService.addSeance( date, heure_debut, duree,methode,0,type,enseignant,matiere);
        
        RequestDispatcher dispatch = request.getRequestDispatcher("/result.jsp");
        request.setAttribute("resultat","Succes"); 
        dispatch.forward(request,response); 
        }else if (action.equalsIgnoreCase("displaySeance")) {
            List<Seance> list = seanceService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplaySeance.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }else if (action.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Seance e = seanceService.getSeanceById(id);
             EnseignantsService enseignantService = new EnseignantsService();
              MatiereService matiereService=new MatiereService();
            List<Enseignants> list = enseignantService.displayAll();
            List<Matiere> list1 = matiereService.displayAll();
            request.setAttribute("resultat2", list);
            request.setAttribute("resultat1", list1);
            //Enseignants enseignant= enseignantService.updateEnseignant(e);
            RequestDispatcher dispatch = request.getRequestDispatcher("/EditSeance.jsp");
            request.setAttribute("resultat", e);
            dispatch.forward(request, response);

        } else if (action.equalsIgnoreCase("edit1")) {
             String date=request.getParameter("date");
        String heure_debut=request.getParameter("heure_debut");
        String duree=request.getParameter("duree");
          String methode=request.getParameter("methode");
     
        String  type=request.getParameter("type");
            int id = Integer.parseInt(request.getParameter("id"));
                 String enseignant = request.getParameter("enseignant");
         String matiere = request.getParameter("matiere");
            Seance e = seanceService.getSeanceById(id);
            e.setDate(date);
            e. setHeure_debut(heure_debut) ;
            e.setDuree(duree);
            e.setMethode(methode);
            e.setType(type);
            e.setEnseignant(enseignant);
            e.setMatiere(matiere);
            
            Seance seance = seanceService.updateSeance(e);
            List<Seance> list = seanceService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplaySeance.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Seance e = seanceService.getSeanceById(id);
            seanceService.deleteSeance(e);
            List<Seance> list = seanceService.displayAll();

            RequestDispatcher dispatch = request.getRequestDispatcher("/DisplaySeance.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }else if (action.equalsIgnoreCase("display")) {
             EnseignantsService enseignantService = new EnseignantsService();
              MatiereService matiereService=new MatiereService();
            List<Enseignants> list = enseignantService.displayAll();
            List<Matiere> list1 = matiereService.displayAll();
            RequestDispatcher dispatch = request.getRequestDispatcher("/AddSeance.jsp");
            request.setAttribute("resultat", list);
            request.setAttribute("resultat1", list1);
            dispatch.forward(request, response);
        }else if (action.equalsIgnoreCase("displaySeanceens")) {
            String nom=request.getParameter("nom");
            List<Seance> list = seanceService.displayAllparid(nom);
            RequestDispatcher dispatch = request.getRequestDispatcher("/MenuEnseignant.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }else if (action.equalsIgnoreCase("displaySeancedep")) {
            int id = Integer.parseInt(request.getParameter("id"));
             session1.setAttribute("id", id);
            DepartementService departementService=new DepartementService();
            Departement d = departementService.getDepartementById(id);
             MatiereService matiereService=new MatiereService();
             String nom =d.getLibelle_departement();
             System.out.println(nom);
            List<Matiere> list1 = matiereService.displayAllpardep(nom);
             System.out.println(list1);
            List<Seance> list = seanceService.displayAllpardep(list1);
            RequestDispatcher dispatch = request.getRequestDispatcher("/Menuchef.jsp");
            request.setAttribute("resultat", list);
            dispatch.forward(request, response);

        }
        else if (action.equalsIgnoreCase("valider")) {
            int id1 = Integer.parseInt(request.getParameter("id1"));    
            Seance e = seanceService.getSeanceById(id1);
            int id = (int) session1.getAttribute("id");
            int validee =1;
            e.setValidee(validee);
            Seance seance = seanceService.valider(e);
            DepartementService departementService=new DepartementService();
            Departement d = departementService.getDepartementById(id);
             MatiereService matiereService=new MatiereService();
             String nom =d.getLibelle_departement();
             System.out.println(nom);
            List<Matiere> list1 = matiereService.displayAllpardep(nom);
             System.out.println(list1);
            List<Seance> list = seanceService.displayAllpardep(list1);
            RequestDispatcher dispatch = request.getRequestDispatcher("/Menuchef.jsp");
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
