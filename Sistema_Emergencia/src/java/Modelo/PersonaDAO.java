/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admi
 */
public class PersonaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from personas";
        List<Persona>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Persona per = new Persona();
                per.setId_persona(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellido(rs.getString(4));
                per.setFecha(rs.getString(5));
                per.setDireccion(rs.getString(6));
                per.setImg(rs.getString(7));
                per.setEstado(rs.getString(8));
                lista.add(per);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Persona per){
        String sql="insert into personas(dni, nombre, apellido, fechanac, direccion, thumbnail, estado) value (?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getDni());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getApellido());
            ps.setString(4, per.getFecha());
            ps.setString(5, per.getDireccion());
            ps.setString(6, per.getImg());
            ps.setString(7, per.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Persona validar(String email, String password){
        String sql="SELECT pr.* FROM users us \n" +
"join users_roles usro on (us.user_id=usro.user_id)\n" +
"join personas pr on (us.persona_id=pr.persona_id) \n" +
"where us.email=? and password=? and usro.role_id=1";
        Persona per=new Persona();        
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);   
            rs=ps.executeQuery();
            while (rs.next()) {
                per.setId_persona(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellido(rs.getString(4));
                per.setFecha(rs.getString(5));
                per.setDireccion(rs.getString(6));
                per.setImg(rs.getString(7));
                per.setEstado(rs.getString(8));                
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return per;
    }
            
}
