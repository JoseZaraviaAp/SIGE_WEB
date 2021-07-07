
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public List listar(){
        String sql="select e.empleado_id,p.dni,p.nombre,p.apellido,p.fechanac,p.direccion, e.estadocivil_pe,cemp.desc_cargo_pe,de.desctipo_pe from empleados e \n" +
"join personas p on (e.persona_id=p.persona_id)\n" +
"join disponibilidad_empleado de on (e.disponibilidadempleado_id = de.disponibilidadempleado_id)\n" +
"join cargo_empleado cemp on (e.cargoempleado_id=cemp.cargoempleado_id) where estado=1 order by e.empleado_id ASC";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Empleado emp = new Empleado();
                emp.setEmpleadoId(rs.getInt(1));
                emp.setDni(rs.getInt(2));
                emp.setNombre(rs.getString(3));
                emp.setApellido(rs.getString(4));
                emp.setFechanac(rs.getString(5));
                emp.setDireccion(rs.getString(6));
                emp.setEstadocivil(rs.getString(7));
                emp.setCargo(rs.getString(8));
                emp.setEstado(rs.getString(9));
                lista.add(emp);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return lista;
    }
    public int agregar(Empleado emp){
        String sql="call registro_empleado(?,?,?,?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getDni().toString());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getFechanac());
            ps.setString(5, emp.getDireccion());
            ps.setString(6, "no image");
            ps.setString(7, "1");
            ps.setString(8, emp.getEstadocivil());
            ps.setString(9, emp.getCargo());
            ps.setString(10, emp.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return r;
        }

    public Empleado listarId(int idemp) {
        String sql="select e.empleado_id,p.dni,p.nombre,p.apellido,p.fechanac,p.direccion, e.estadocivil_pe,cemp.desc_cargo_pe,de.desctipo_pe from empleados e \n" +
"join personas p on (e.persona_id=p.persona_id)\n" +
"join disponibilidad_empleado de on (e.disponibilidadempleado_id = de.disponibilidadempleado_id)\n" +
"join cargo_empleado cemp on (e.cargoempleado_id=cemp.cargoempleado_id) where estado=1 and e.empleado_id="+idemp;
        Empleado emp = new Empleado();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){                
                emp.setEmpleadoId(rs.getInt(1));
                emp.setDni(rs.getInt(2));
                emp.setNombre(rs.getString(3));
                emp.setApellido(rs.getString(4));
                emp.setFechanac(rs.getString(5));
                emp.setDireccion(rs.getString(6));
                emp.setEstadocivil(rs.getString(7));
                emp.setCargo(rs.getString(8));
                emp.setEstado(rs.getString(9));                
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return emp;
    }

    public int actualizar(Empleado emp) {
        String sql="call actualizar_empleado(?,?,?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, emp.getEmpleadoId());
            ps.setString(2, emp.getDni().toString());
            ps.setString(3, emp.getNombre());
            ps.setString(4, emp.getApellido());
            ps.setString(5, emp.getFechanac());
            ps.setString(6, emp.getDireccion());
            ps.setString(7, emp.getEstadocivil());
            ps.setString(8, emp.getCargo());
            ps.setString(9, emp.getEstado());          
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void eliminar(Integer i, Integer idemp) {
         String sql="call eliminar_empleado(?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, i.toString());
            ps.setInt(1, idemp);
            ps.executeUpdate();            
        } catch (Exception e) {
        }
    }
}
