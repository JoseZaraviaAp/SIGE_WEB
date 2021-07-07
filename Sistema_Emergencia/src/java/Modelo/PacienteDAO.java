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
public class PacienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select PA.paciente_id, PE.dni, PE.nombre, PE.apellido, PE.fechanac, PE.direccion, PE.thumbnail,\n" +
        "PE.estado, PA.tipo_sangre_usu, PA.peso_pa, PA.talla_pa, PA.numero_contacto_usu, PA.alergias_usu \n" +
        "from pacientes PA \n" +
        "INNER JOIN personas PE ON PA.persona_id = PE.persona_id\n" +
        "ORDER BY paciente_id ASC";
        List<Paciente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Paciente pa = new Paciente();
                pa.setId_paciente(rs.getInt(1));
                pa.setDni(rs.getString(2));
                pa.setNombre(rs.getString(3));
                pa.setApellido(rs.getString(4));
                pa.setFechanac(rs.getDate(5));
                pa.setDireccion(rs.getString(6));
                pa.setThumbnail(rs.getString(7));
                pa.setEstado(rs.getString(8));
                pa.setTsangre(rs.getString(9));
                pa.setPeso(rs.getDouble(10));
                pa.setTalla(rs.getDouble(11));
                pa.setContacto(rs.getString(12));
                pa.setAlergias(rs.getString(13));
                lista.add(pa);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void eliminar(Integer estado,Integer pacienteId){
        String sql="call eliminar_paciente(?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, estado.toString());
            ps.setInt(1, pacienteId);
            int executeUpdate = ps.executeUpdate();            
        } catch (Exception e) {
        }
        
    }
    
}
