package Entidades;

import java.time.LocalDate;

public class Inscripcion {
    private int idInscripcion;
    private Clase clase;
    private Socio socio;
    private LocalDate fechaInscripcion;
    
    // constructor completo

    public Inscripcion(int idInscripcion, Clase clase, Socio socio, LocalDate fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.clase = clase;
        this.socio = socio;
        this.fechaInscripcion = fechaInscripcion;
    }
    
    // sin id

    public Inscripcion(Clase clase, Socio socio, LocalDate fechaInscripcion) {
        this.clase = clase;
        this.socio = socio;
        this.fechaInscripcion = fechaInscripcion;
    }
    
    // vacio 

    public Inscripcion() {
    }
    
    // getter y setter

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    // to string

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", clase=" + clase + ", socio=" + socio + ", fechaInscripcion=" + fechaInscripcion + '}';
    }
    
    
}
