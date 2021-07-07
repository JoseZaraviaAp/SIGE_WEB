package Modelo;

public class Empleado 
{
    private Integer empleadoId;
    private Integer dni;
    private String nombre;
    private String apellido;
    private String fechanac;
    private String direccion;
    private String estadocivil;
    private String cargo;
    private String estado;

    public Empleado() {
    }

    public Empleado(Integer empleadoId, Integer dni, String nombre, String apellido, String fechanac, String direccion, String estadocivil, String cargo, String estado) {
        this.empleadoId = empleadoId;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanac = fechanac;
        this.direccion = direccion;
        this.estadocivil = estadocivil;
        this.cargo = cargo;
        this.estado = estado;
    } 

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
