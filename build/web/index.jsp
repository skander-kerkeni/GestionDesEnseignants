<%-- 
    Document   : index
    Created on : May 29, 2021, 9:39:31 AM
    Author     : marouen
--%>

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
            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
                <div class="col-md-5 p-lg-5 mx-auto my-5">
                    <h1 class="display-4 fw-normal">Punny headline</h1>
                    <p class="lead fw-normal">And an even wittier subheading to boot. Jumpstart your marketing efforts with this example based on Apple’s marketing pages.</p>
                    <a class="btn btn-outline-secondary" href="#">Coming soon</a>
                </div>
                <div class="product-device shadow-sm d-none d-md-block"></div>
                <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
            </div>


        </main>

        <footer class="container py-5">
            <div class="row">
                <div class="col-12 col-md">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
                    <small class="d-block mb-3 text-muted">&copy; 2017–2021</small>
                </div>
                <div class="col-6 col-md">
                    <h5>Features</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Cool stuff</a></li>
                        <li><a class="link-secondary" href="#">Random feature</a></li>
                        <li><a class="link-secondary" href="#">Team feature</a></li>
                        <li><a class="link-secondary" href="#">Stuff for developers</a></li>
                        <li><a class="link-secondary" href="#">Another one</a></li>
                        <li><a class="link-secondary" href="#">Last time</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>Resources</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Resource name</a></li>
                        <li><a class="link-secondary" href="#">Resource</a></li>
                        <li><a class="link-secondary" href="#">Another resource</a></li>
                        <li><a class="link-secondary" href="#">Final resource</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>Resources</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Business</a></li>
                        <li><a class="link-secondary" href="#">Education</a></li>
                        <li><a class="link-secondary" href="#">Government</a></li>
                        <li><a class="link-secondary" href="#">Gaming</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>About</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Team</a></li>
                        <li><a class="link-secondary" href="#">Locations</a></li>
                        <li><a class="link-secondary" href="#">Privacy</a></li>
                        <li><a class="link-secondary" href="#">Terms</a></li>
                    </ul>
                </div>
            </div>
        </footer>


        <script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>


    </body>
</html>
