<%-- 
    Document   : Persona
    Created on : 25-jun-2021, 10:53:08
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
            <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Persona" method="POST">
                    <div>
                        <label>DNI</label>
                        <input type="text" value="${personas.getDni()}" name="dni" class="form-control">
                    </div>
                    <div>
                        <label>NOMBRE</label>
                        <input type="text" value="${personas.getNombre()}" name="nombre" class="form-control">
                    </div>
                    <div>
                        <label>APELLIDO</label>
                        <input type="text" value="${personas.getApellido()}" name="apellido" class="form-control">
                    </div>
                    <div>
                        <label>FECHA</label>
                        <input type="text" value="${personas.getFecha()}" name="fecha" class="form-control">
                    </div>
                    
                    <div>
                        <label>DIRECCION</label>
                        <input type="text" value="${personas.getDireccion()}" name="direccion" class="form-control">
                    </div>
                    
                    <div>
                        <label>IMAGEN</label>
                        <input type="text" value="${personas.getImg()}" name="thumbnail" class="form-control">
                    </div>
                    
                    <div>
                        <label>ESTADO</label>
                        <input type="text" value="${personas.getEstado()}" name="estado" class="form-control">
                        <select class="form-control" name="disponibilidad" id="exampleFormControlSelect1" disabled>
                      <option ${personas.getEstado()=="2"?"selected":""} value="2">DESHABILITADO</option>
                      <option ${personas.getEstado()=="1"?"selected":""} value="1">HABILITADO</option>
                    </select>
                    </div>
                    
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>
            <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>FECHA DE NACIMIENTO</th>
                        <th>DIRECCION</th>
                        <th>IMAGEN</th>
                        <th>ESTADO</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="person" items="${personasx}">
                        <tr>
                        <td>${person.getId_persona()}</td>
                        <td>${person.getDni()}</td>
                        <td>${person.getNombre()}</td>
                        <td>${person.getApellido()}</td>
                        <td>${person.getFecha()}</td>
                        <td>${person.getDirección()}</td>
                        <td>${person.getImg()}</td>
                        <td>${person.getEstado()}</td>
                        
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Persona&accion=Editar&id=${am.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Persona&accion=Delete&id=${am.getId()}">Eliminar</a>
                        </td>
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

