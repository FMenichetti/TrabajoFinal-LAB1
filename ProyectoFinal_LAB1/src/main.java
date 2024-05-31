
import AccesoDatos.*;
import Entidades.*;


public class main {

    
    public static void main(String[] args) {
        Entrenador entrenador = new Entrenador("49211323", "Alfio", "Arias", "Zumba", true);
        
        AccesoClase ac = new AccesoClase();
        AccesoEntrenador ae = new AccesoEntrenador();
        AccesoInscripcion ai = new AccesoInscripcion();
        AccesoMembresia am = new AccesoMembresia();
        AccesoSocio as = new AccesoSocio();
        
        //ae.guardarEntrenador(entrenador);
        
        //System.out.println(ae.buscarEntrenador(21));
        //System.out.println(ae.buscarEntrenadorPorDni("47586920"));
        
//        for (Entrenador entrenadores : ae.listarEntrenador()) {
//            System.out.println(entrenadores);
//        }

//        entrenador = ae.buscarEntrenador(21);
//        entrenador.setNombre("Fabrizio");
//        ae.modificarEntrenador(entrenador);

          //ae.eliminarEntrenador(21);
        
        
    }
    
}
