<%-- 
    Document   : Menuchef
    Created on : 22 juin 2021, 13:40:06
    Author     : Lenovo
--%>

<%@page import="iit.enseignants.entites.Seance"%>
<%@page import="java.util.List"%>
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
        <div class="position-relative overflow-hidden p-3 bg-light">
        <div>
            <a href="./logout" class="btn btn-primary">Logout
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                                
                               
                                </svg>
                            </a>
        </div>
            <br>
        <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3  bg-light">
                <div class=" text-center">
        <h1>Liste des seances</h1>
                </div>
        <br>
        <div class="panel-body">
            <table id="tbl-student" class="table table-responsive table-bordered" cellpadding ="0" width="100%">
                <thead>
                    <tr>
                        
                        <th>Date</th>
                        <th>Heure_debut</th>
                        <th>Duree</th>
                        <th>Methode</th>
                        <th>Validee</th>
                        <th>Type</th>
                        <th>Enseignant</th>
                        <th>Matiere</th>
                        <th>Action</th>

                    </tr>  

                    <%
                        if (request.getAttribute("resultat") != null) {
                            List<Seance> rs = (List<Seance>) request.getAttribute("resultat");
                            for (Seance ee : rs) {
                    %>

                    <tr>
                        <td><%=ee.getDate()%></td>
                        <td><%=ee.getHeure_debut()%></td>
                        <td><%=ee.getDuree()%></td>
                        <td><%=ee.getMethode()%></td>
                        <td>
                             <%
                        if (ee.getValidee()== 0) {
                          
                    %>
                            <a href="./SeanceController?action=valider&id1=<%=ee.getId_seance()%>" class="btn btn-primary">Valider
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                                
                                </svg>
                            </a> <%

                            
                        }else{ %> Seance validée
 <%

}
                    %></td>
                         <td><%=ee.getType()%></td>
                         <td><%=ee.getEnseignant()%></td>
                         <td><%=ee.getMatiere()%></td>
                        
                        <td><a href="./SeanceController?action=edit&id=<%=ee.getId_seance()%>" class="btn btn-primary">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                </svg>
                                
                            </a>
                            <a href="./SeanceController?action=delete&id=<%=ee. getId_seance()%>" class="btn btn-outline-danger">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                            </a></td>

                    </tr> 


                    <%

                            }
                        }
                    %>

            </table>    
        </div>
    </body>
</html>
