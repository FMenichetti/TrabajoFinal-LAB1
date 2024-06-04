
import AccesoDatos.*;
import Entidades.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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
     //   socio = as.buscarSocioPorDni("909090909M");

      // System.out.println(""+socio);
        
//
//        as.modificarSocio(socio);
//        
//        as.eliminarSocio(91);

    //    Membresia membresia = new Membresia(socio, 7888888, LocalDate.of(2020, Month.MARCH, 1),LocalDate.of(2023, Month.MARCH, 1), 100, true);
        
      //  am.crearMembresia(membresia);
        
    //  socio = as.buscarSocioPorDni("898989898L");
      //  Membresia membresia2 = new Membresia(socio, 8, LocalDate.of(2020, Month.MARCH, 1),LocalDate.of(2024, Month.MARCH, 1), 100, true);

     //   am.crearMembresia(membresia2);
        
        //am.eliminarMembresia(am.buscarMembresiaPorIdSocio(socio.getIdSocio()).getIdMembresia());
      //  membresia=am.buscarMembresiaPorIdSocio(89);
      //  membresia.setCantidadPases(10000);
      //  am.modificarMembresia(membresia);
        
      
      Clase clase=new Clase(20, "zumba", ae.buscarEntrenadorPorDni("28475698"), LocalTime.of(13, 0, 0), true);
        Clase clase2=new Clase(20, "zumba", ae.buscarEntrenadorPorDni("28475698"), LocalTime.of(14, 0, 0), true);
      
      //arreglar despues
      //ac.guardarClase(clase2);
    // clase=ac.buscarClase(57);
     //    System.out.println(""+clase);
     //clase=ac.buscarClase(59);
    // clase.setNombre("juanjo");
     
    // ac.modificarClase(clase);
     
      /*  for (Clase listarClase : ac.listarClases()) {
            System.out.println(""+listarClase);
        }*/
      
     //ac.eliminarClase(58);
      
      Inscripcion i1 = new Inscripcion(ac.buscarClase(3), as.buscarSocio(7), LocalDate.of(2020, Month.MARCH, 5));
      
      //ai.guardarInscripcion(i1);
      //System.out.println(ai.buscarInscripcionPorId(2));
//        for (Inscripcion listarInscripcione : ai.listarInscripciones()) {
//            System.out.println(listarInscripcione);
//        }
     
//     i1 = ai.buscarInscripcionPorId(49);
//     i1.setFechaInscripcion(LocalDate.of(2021, Month.MARCH, 19));
//     ai.modificarInscripcion(i1);

    ai.borrarInscripcion(49);
     
        
    }
}
