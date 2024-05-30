package Entidades;

public class Entrenador {

    private int idEntrenador;
    private String dni;
    private String nombre;
    private String apellido ;
    private String especialidad;
    private boolean estado;

    public Entrenador() {
    }

    public Entrenador(String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Entrenador(int idEntrenador, String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.idEntrenador = idEntrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    

    @Override
    public String toString() {
        return "Entrenador: " + nombre + " + apellido: " + apellido + ")";
    }
    
    
    
}
