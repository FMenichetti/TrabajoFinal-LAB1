
import AccesoDatos.*;
import Entidades.*;
import java.time.LocalDate;

public class main {

    public static void main(String[] args) {
        Entrenador entrenador = new Entrenador("49211323", "Alfio", "Arias", "Zumba", true);
        Socio socio = new Socio("486132165", "eduardo", "rotte", 36, "edurotte@mail.com", "125369", true);

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
        // as.guardarSocio(socio);
//        as.buscarSocio(91);
//        System.out.println("" + as.buscarSocioPorDni(socio.getDni()));
//        /* for (Socio socio1 : as.listarSocio()) {
//            System.out.println(""+socio1);
//        }*/
//
        socio = as.buscarSocioPorDni(socio.getDni());

        System.out.println(""+socio);
//
//        as.modificarSocio(socio);
//        
//        as.eliminarSocio(91);

        Membresia membresia = new Membresia(socio, 8, LocalDate.MIN, LocalDate.MAX, 100, true);
        am.crearMembresia(membresia);
        
        am.buscarMembresiaPorIdSocio(91);

    }
}
