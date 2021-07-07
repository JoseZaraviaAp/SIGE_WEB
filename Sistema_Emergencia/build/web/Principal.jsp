<%-- 
    Document   : Principal
    Created on : 20-feb-2021, 10:32:35
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body  style="background-image: url('img/ambulancia.jpg');">
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Home" target="myFrame">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Ambulancia&accion=Listar" target="myFrame">Ambulancias</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleados&accion=Listar" target="myFrame">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Paciente&accion=Listar" target="myFrame">Pacientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Solicitud&accion=Listar" target="myFrame">Solicitud Emergencia</a>
                    </li>
                    
                </ul>
                </div>
                <div class="dropdown">
                    <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Nombre de Usuario: Jose
                    </button>
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                           <img src="img/usuario.png" alt="60" width="60"/>
                        </a>
                        
                        <a class="dropdown-item" href="#">Rol : Admin</a>
                       
                        <div class="dropdown-divider"></div>
                        <form action="index.jsp" method="POST">
                            <button name="accion" value="Salir" class="dropdown-item">Cerrar Sesión</button>
                        </form>
                    </div>
                
            </div>
        </nav>
                        <div class="p-3 mb-2 bg-transparent text-dark" style="height: 530px;">
                            <iframe name="myFrame" style="height: 140%; width: 100%; border: none" src="https://app.powerbi.com/view?r=eyJrIjoiNjVlN2JlNmUtMjc5Zi00MzYxLTg5Y2UtZjljZDVjM2Q3ZWU4IiwidCI6ImM0YTY2YzM0LTJiYjctNDUxZi04YmUxLWIyYzI2YTQzMDE1OCIsImMiOjR9&pageName=ReportSection" frameborder="0" allowFullScreen="true"></iframe>
                        </div>                
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
