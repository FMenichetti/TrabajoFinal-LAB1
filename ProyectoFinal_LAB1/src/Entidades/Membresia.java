package Entidades;

import java.time.LocalDate;

public class Membresia {
    //Atributos
    private int idMembresia;
    private Socio idSocio;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean estado;
    
    //Constructor vacío
    public Membresia() {
    }
    
    //Constructor sin idMembresia
    public Membresia(Socio idSocio, String tipo, LocalDate fechaInicio, LocalDate fechaFin, boolean estado) {
        this.idSocio = idSocio;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }
    
    //Constructor completo
    public Membresia(int idMembresia, Socio idSocio, String tipo, LocalDate fechaInicio, LocalDate fechaFin, boolean estado) {
        this.idMembresia = idMembresia;
        this.idSocio = idSocio;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }
    
    //Metodos Getters & Setters
    public int getIdMembresia() {
        return idMembresia;
    }
    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }
    public Socio getIdSocio() {
        return idSocio;
    }
    public void setIdSocio(Socio idSocio) {
        this.idSocio = idSocio;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Metodo toString()
    @Override
    public String toString() {
        return "Membresia{" + "idMembresia=" + idMembresia + ", idSocio=" 
                + idSocio + ", tipo=" + tipo + ", fechaInicio=" + fechaInicio 
                + ", fechaFin=" + fechaFin + ", estado=" + estado + '}';
    }
    
       
    
}
