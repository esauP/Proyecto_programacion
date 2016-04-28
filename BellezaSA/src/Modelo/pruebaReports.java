/*
 *Una clase simple que recoge los datos de los asistentes: dni, nombre, apellido y direccion
con sus getters y setters
 */
package Modelo;

/**
 *
 * @author SAMUEL
 */
public class pruebaReports {
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;

    public pruebaReports(Integer id, String nombre, String apellido, String direccion, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
    }

    

    public pruebaReports() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
