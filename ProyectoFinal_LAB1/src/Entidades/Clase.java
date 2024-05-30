package Entidades;

import AccesoDatos.AccesoEntrenador;
import java.time.LocalTime;

public class Clase {

    private int idClase, cantidad;
    private String nombre;
    private Entrenador idEntrenador;
    private LocalTime horario;
    private boolean estado;
    
    // constructores
    
    // COMPLETO

    public Clase(int idClase, int cantidad, String nombre, Entrenador idEntrenador, LocalTime horario, boolean estado) {
        this.idClase = idClase;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.idEntrenador = idEntrenador;
        this.horario = horario;
        this.estado = estado;
    }
    
    
    // SIN ID

    public Clase(int cantidad, String nombre, Entrenador idEntrenador, LocalTime horario, boolean estado) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.idEntrenador = idEntrenador;
        this.horario = horario;
        this.estado = estado;
    }

    // VACIO
    public Clase() {
    }
    
    // GETTER Y SETTER

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Entrenador idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    // TO STRING

    @Override
    public String toString() {
        return "Clase{" + "idClase=" + idClase + ", cantidad=" + cantidad + ", nombre=" + nombre + ", idEntrenador=" + idEntrenador + ", horario=" + horario + ", estado=" + estado + '}';
    }
    
    
    
    
}
