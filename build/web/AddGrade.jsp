<%-- 
    Document   : AddEnseignant
    Created on : May 25, 2021, 12:15:14 PM
    Author     : marouen
--%>

<%@page import="iit.enseignants.entites.Enseignants"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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


        <main>
            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3  bg-light">
                <div class=" text-center">
        <h1>Ajouter grade</h1>
                </div>

        <div class="row">
         <div class="col-sm-4">
        <form method="post" action="./GradeController">
            <input type="hidden" name="action" value="ajouter"/>
            <div alight="left">
                <label class="form-label">Libelle</label>
                <input type="text" class="form-control" placeholder="libelle" name="libelle" id="libelle" required >
            </div>
            <div alight="left">
                <label class="form-label"><h3>Prix :</h3></label><br>
                <label class="form-label">Heure de cours :</label>
                <input type="text" class="form-control" placeholder="prix_H_cours" name="prix_H_cours" id="prix_H_cours" required >
            </div>
            <div alight="left">
                <label class="form-label">Heure de TP :</label>
                <input type="text" class="form-control" placeholder="prix_H_td" name="prix_H_td" id="prix_H_td" required >
            </div>
            <div alight="left">
                <label class="form-label">Heure de TD :</label>
                <input type="text" class="form-control" placeholder="prix_H_tp" name="prix_H_tp" id="prix_H_tp" required >
            </div>
        
            
                
       
            <br>
    
            
            <input type="submit" name="OK" value="Ajouter" class="btn btn-info"/>
            
        </form>
         </div>
        
    </body>
</html>
