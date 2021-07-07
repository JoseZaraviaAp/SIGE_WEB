<%-- 
    Document   : Paciente
    Created on : 01-jul-2021, 21:44:23
    Author     : admi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Personas</title>
    </head>
    <body>
        <div class="d-flex">            
            <div class="table-responsive">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>FECHA DE NACIMIENTO</th>
                        <th>DIRECCION</th>
                        <th>ESTADO</th>
                        <th>TIPO DE SANGRE</th>
                        <th>PESO</th>
                        <th>TALLA</th>
                        <th>CONTACTO</th>
                        <th>ALERGIAS</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pa" items="${pacientes}">
                        <tr>
                        <td>${pa.getId_paciente()}</td>
                        <td>${pa.getDni()}</td>
                        <td>${pa.getNombre()}</td>
                        <td>${pa.getApellido()}</td>
                        <td>${pa.getFechanac()}</td>
                        <td>${pa.getDireccion()}</td>
                        <td>${pa.getEstado()}</td>
                        <td>${pa.getTsangre()}</td>
                        <td>${pa.getPeso()}</td>
                        <td>${pa.getTalla()}</td>
                        <td>${pa.getContacto()}</td>
                        <td>${pa.getAlergias()}</td>
                        <!-- 
                        <td>
                            <a class="btn btn-danger" href="Controlador?menu=Paciente&accion=Delete&id=${pa.getId_paciente()}">Eliminar</a>
                        </td>
                        -->
                    </tr>                        
                    </c:forEach>    
                    
                </tbody>
            </table>
            
        </div>
        </div>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

