<%-- 
    Document   : Ambulancia
    Created on : 24-jun-2021, 21:11:40
    Author     : admi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Ambulancias</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Ambulancia" method="POST">
                    <div>
                        <label>PLACA</label>
                        <input type="text" value="${ambulancias.getPlaca()}" name="placa" class="form-control">
                    </div>
                   <div class="form-group">
                    <label for="exampleFormControlSelect1">DISPONIBILIDAD</label>
                    <select class="form-control" name="disponibilidad" id="exampleFormControlSelect1">
                        <option selected="true" disabled="disabled">--Seleccione--</option>
                      <option ${ambulancias.getIddispo()=="2"?"selected":""} value="2">ACTIVO</option>
                      <option ${ambulancias.getIddispo()=="1"?"selected":""} value="1">INACTIVO</option>
                    </select>
                  </div>                    
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
                    
            </div>
        </div>
            <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>PLACA</th>
                        <th>DISPONIBILIDAD</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="am" items="${ambulanciasv}">
                        <tr>
                        <td>${am.getId()}</td>
                        <td>${am.getPlaca()}</td>
                        <td>${am.getIddispo()}</td>
                        
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Ambulancia&accion=Editar&id=${am.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Ambulancia&accion=Delete&id=${am.getId()}">Eliminar</a>
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