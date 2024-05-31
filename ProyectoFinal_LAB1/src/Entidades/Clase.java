package Entidades;

import AccesoDatos.AccesoEntrenador;
import java.time.LocalTime;

public class Clase {

    private int idClase, capacidad;
    private String nombre;
    private Entrenador entrenador;
    private LocalTime horario;
    private boolean estado;
    
    // constructores
    
    // COMPLETO

    public Clase(int idClase, int cantidad, String nombre, Entrenador entrenador, LocalTime horario, boolean estado) {
        this.idClase = idClase;
        this.capacidad = cantidad;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.horario = horario;
        this.estado = estado;
    }
    
    
    // SIN ID

    public Clase(int cantidad, String nombre, Entrenador idEntrenador, LocalTime horario, boolean estado) {
        this.capacidad = cantidad;
        this.nombre = nombre;
        this.entrenador = idEntrenador;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
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
        return "Clase{" + "idClase=" + idClase + ", capacidad=" + capacidad + ", nombre=" + nombre + ", idEntrenador=" + entrenador + ", horario=" + horario + ", estado=" + estado + '}';
    }
    
    
    
    
}
