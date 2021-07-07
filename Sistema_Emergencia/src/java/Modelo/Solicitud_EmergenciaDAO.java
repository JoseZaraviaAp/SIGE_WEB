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
public class Solicitud_EmergenciaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from solicitud_emergencia";
        List<Solicitud_Emergencia>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Solicitud_Emergencia se = new Solicitud_Emergencia();
                se.setId(rs.getInt(1));
                se.setDescripcion(rs.getString(2));
                se.setUbicacion(rs.getString(3));
                se.setFecha(rs.getDate(4));
                se.setPaciente(rs.getInt(5));
                lista.add(se);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public Solicitud_Emergencia listarId(int id){
        Solicitud_Emergencia sem = new Solicitud_Emergencia();
        String sql="select * from solicitud_emergencia where solicitudemergencia_id="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                sem.setId(rs.getInt(1));
                sem.setDescripcion(rs.getString(2));
                sem.setUbicacion(rs.getString(3));
                sem.setFecha(rs.getDate(4));
                sem.setPaciente(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sem;
    }
    
    
}
