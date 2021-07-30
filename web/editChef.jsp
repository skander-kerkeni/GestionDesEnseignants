<%-- 
    Document   : editChef
    Created on : 20 juin 2021, 17:37:59
    Author     : Lenovo
--%>

<%@page import="iit.enseignants.entites.Departement"%>
<%@page import="iit.enseignants.entites.Enseignants"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
               <style>
            header{
                background-color: rgba(0, 0, 0, .85);
            }
            .site-header a {
                color: #8e8e8e;
                transition: color .15s ease-in-out;
            }
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
    </head>
    </head>
        <header class="site-header sticky-top py-1 ">
            <nav class="navbar-band container d-flex flex-column flex-md-row justify-content-between">
                <!-- <a class="py-2" href="#" aria-label="Product">
                     <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
                 </a> -->
                <a class="py-2 d-none d-md-inline-block" href="./EnseignantsController2?action=displayEnseignant">Enseignant</a>
                <a class="py-2 d-none d-md-inline-block" href="./GradeController?action=displayGrade">Grade</a>
                <a class="py-2 d-none d-md-inline-block" href="./MatiereController?action=displayMatiere">Matiere</a>
                <a class="py-2 d-none d-md-inline-block" href="./SeanceController?action=displaySeance">Seance</a>
                <a class="py-2 d-none d-md-inline-block" href="./NiveauController1?action=displayNiveau">Niveau</a>
                <a class="py-2 d-none d-md-inline-block" href="./DepartementController?action=displayDepartement">Departement</a>
                <a class="py-2 d-none d-md-inline-block" href="./logout">Logout</a>

            </nav>
        </header>
    <body>
          <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3  bg-light">
                <div class=" text-center">
        <h1>Ajouter Chef departement</h1>
                </div>
       
         <%
            if (request.getAttribute("resultat1") != null) {
                Departement departement = (Departement) (request.getAttribute("resultat1"));

        %>
         <form method="post" action="./DepartementController">
            <input type="hidden" name="action" value="editchef1"/>
            <input type="hidden" name="id" value="<%=departement.getId_departement()%>"/>
        
              <div alight="left">
                <label class="form-label"> Enseignant :</label>
                
                 <select name="enseignant">
                      <%
                        if (request.getAttribute("resultat") != null) {
                            List<Enseignants> rs = (List<Enseignants>) request.getAttribute("resultat");
                            for (Enseignants ee : rs) {
                    %>
                     
            <option><%=ee.getPrenom()%><%=ee.getNom()%></option>
              <%

                            }
                        }
                    %>
            
        </select><br>
       
            </div>
            
       
            <br>
    
            
            <input type="submit" name="OK" value="Ajouter" class="btn btn-info"/>
            
        </form>
                    <%}%>
    </body>
</html>
