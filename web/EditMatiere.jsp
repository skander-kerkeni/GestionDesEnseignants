<%-- 
    Document   : EditEnseignant
    Created on : May 29, 2021, 11:25:45 AM
    Author     : marouen
--%>

<%@page import="iit.enseignants.entites.Departement"%>
<%@page import="java.util.List"%>
<%@page import="iit.enseignants.entites.Matiere"%>
<%@page import="iit.enseignants.entites.Grade"%>
<%@page import="iit.enseignants.entites.Niveau"%>
<%@page import="iit.enseignants.entites.Enseignants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <body>
        
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


        
            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3  bg-light">
                  <div class=" text-center">
        <h1>Modifier  matiere</h1>
                </div>
        
        
        
        <%
            if (request.getAttribute("resultat3") != null) {
                Matiere matiere = (Matiere) (request.getAttribute("resultat3"));

        %>
        <div class="row">
            <div class="col-sm-4">
                <form method="post" action="./MatiereController">
                    <input type="hidden" name="action" value="edit1"/>
                    <input type="hidden" name="id" value="<%=matiere.getId_matiere()%>"/>
                    <div alight="left">
                        <label class="form-label">Libelle</label>
                        <input type="text" class="form-control" value="<%=matiere.getLibelle()%>"  name="libelle" id="libelle" required >
                    </div>
                    <div alight="left">
                         <label class="form-label"> charge :</label> <br>
           
                        <label class="form-label"> Heure de cours</label>
                        <input type="text" class="form-control" value="<%=matiere.getTp() %>"  name="tp" id="tp" required >
                    </div>
                    <div alight="left">
                        <label class="form-label">Heure de TP :</label>
                        <input type="text" class="form-control" value="<%=matiere.getTd()%>"  name="td" id="td" required >
                    </div>
                    <div alight="left">
                        <label class="form-label">  Heure de TD :</label>
                        <input type="text" class="form-control" value="<%=matiere.getCours()%>"  name="cours" id="cours" required >
                    </div>
                    <div alight="left">
                
     
        </div>
                      <div alight="left">
                <label class="form-label"> Departement :</label>
                
                 <select name="departement">
                      <%
                        if (request.getAttribute("resultat1") != null) {
                            List<Departement> rs = (List<Departement>) request.getAttribute("resultat1");
                            for (Departement ee : rs) {
                    %>
                     
            <option><%=ee.getLibelle_departement()%></option>
              <%

                            }
                        }
                    %>
            
        </select><br>
       
            </div>
                       <div alight="left">
                <label class="form-label"> Niveau :</label>
                
                 <select name="niveau">
                      <%
                        if (request.getAttribute("resultat2") != null) {
                            List<Niveau> rs = (List<Niveau>) request.getAttribute("resultat2");
                            for (Niveau ee : rs) {
                    %>
                     
            <option><%=ee.getLibelle()%></option>
              <%

                            }
                        }
                    %>
            
        </select><br>
       
            </div>
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
       
                    <br>


        <input type="submit" name="OK" value="Modifier" class="btn btn-info"/>

    </form>
</div>
</div>
<%}%>
</body>
</html>


