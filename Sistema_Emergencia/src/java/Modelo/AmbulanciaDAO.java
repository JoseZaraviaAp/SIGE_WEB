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
public class AmbulanciaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select A.ambulancia_id, A.placa, D.descdispo_ambu from ambulancias A \n" +
"INNER JOIN disponibilidad_ambulancias D ON A.dispoambu_id = D.dispoambu_id \n" +
"ORDER BY ambulancia_id ASC";
        List<Ambulancia>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Ambulancia amb = new Ambulancia();
                amb.setId(rs.getInt(1));
                amb.setPlaca(rs.getString(2));
                amb.setIddispo(rs.getString(3));
                lista.add(amb);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Ambulancia amb){
        String sql="INSERT INTO ambulancias(`placa`,`dispoambu_id`)VALUES(?,?);";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, amb.getPlaca());
            ps.setString(2, amb.getIddispo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        }    
    public Ambulancia listarId(int id){
        Ambulancia amb = new Ambulancia();
        String sql="select * from ambulancias where ambulancia_id="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                amb.setPlaca(rs.getString(2));
                amb.setIddispo(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return amb;
    }
        public int actualizar (Ambulancia amb){
        String sql="UPDATE ambulancias SET placa = ?,dispoambu_id = ? WHERE ambulancia_id = ?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, amb.getPlaca());
            ps.setString(2, amb.getIddispo());
            ps.setInt(3, amb.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
        }    
        public void delete(int id){
        String sql="delete from ambulancias where ambulancia_id="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
    }
    
}
