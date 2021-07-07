<%-- 
    Document   : Empleado
    Created on : 05-jul-2021, 17:37:24
    Author     : jose_
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Empleados</title>
    </head>
    <body>
        <div class="d-flex">      
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleados" method="POST">
                        <div>
                            <label>DNI</label>
                            <input type="text" maxlength="8" value="${empleads.getDni()}" name="dni" class="form-control">
                        </div>
                        <div>
                            <label>NOMBRE</label>
                            <input type="text" maxlength="50" value="${empleads.getNombre()}" name="nombre" class="form-control">
                        </div>
                        <div>
                            <label>APELLIDO</label>
                            <input type="text" maxlength="50" value="${empleads.getApellido()}" name="apellido" class="form-control">
                        </div>
                        <div>
                            <label>FECHA</label>
                            <input type="date" value="${empleads.getFechanac()}" name="fecha" class="form-control">
                        </div>

                        <div>
                            <label>DIRECCION</label>
                            <input type="text" value="${empleads.getDireccion()}" name="direccion" class="form-control">
                        </div>

                        <div>
                            <label>ESTADO CIVIL</label>
                            <select class="form-control" name="cargo" id="exampleFormControlSelect1">
                                <option selected="true" disabled="disabled">--Seleccione--</option>
                                <option ${empleads.getEstadocivil()=="C"?"selected":""} value="2">C</option>
                                <option ${empleads.getEstadocivil()=="S"?"selected":""} value="3">S</option>
                                <option ${empleads.getEstadocivil()=="V"?"selected":""} value="3">V</option>
                                <option ${empleads.getEstadocivil()=="D"?"selected":""} value="3">D</option>
                            </select>
                        </div>
                            <br>
                        <div>
                            <label>CARGO</label>
                            <select class="form-control" name="cargo" id="exampleFormControlSelect1">
                                <option selected="true" disabled="disabled">--Seleccione--</option>
                                <option ${empleads.getCargo()=="PARAMÉDICO"?"selected":""} value="2">PARAMÉDICO</option>
                                <option ${empleads.getCargo()=="CHOFER"?"selected":""} value="3">CHOFER</option>
                            </select>
                        </div>
                        <br>
                        <div>
                            <label>DISPONIBILIDAD</label>
                            <select class="form-control" name="disponibilidad" id="exampleFormControlSelect1">
                                    <option selected="true" disabled="disabled">--Seleccione--</option>
                                <option ${empleads.getEstado()=="ACTIVO"?"selected":""} value="1">ACTIVO</option>
                                <option ${empleads.getEstado()=="NO ACTIVO"?"selected":""} value="2">INACTIVO</option>
                            </select>
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>            
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
                            <th>ESTADO CIVIL</th>
                            <th>CARGO</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="emp" items="${empls}">
                            <tr>
                                <td>${emp.getEmpleadoId()}</td>
                                <td>${emp.getDni()}</td>
                                <td>${emp.getNombre()}</td>
                                <td>${emp.getApellido()}</td>
                                <td>${emp.getFechanac()}</td>
                                <td>${emp.getDireccion()}</td>
                                <td>${emp.getEstadocivil()}</td>
                                <td>${emp.getCargo()}</td>
                                <td>${emp.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Editar&id=${emp.getEmpleadoId()}">Editar</a>
                                   <!-- <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Delete&id=${emp.getEmpleadoId()}">Eliminar</a>-->                               
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
