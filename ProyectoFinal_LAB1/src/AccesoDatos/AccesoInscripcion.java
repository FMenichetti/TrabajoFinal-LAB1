package AccesoDatos;

import Entidades.Inscripcion;
import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AccesoInscripcion {

    private Connection con;
    AccesoSocio as;
    AccesoClase ac;

    public AccesoInscripcion() {
        con = Conexion.getConexion();
        as = new AccesoSocio();
        ac = new AccesoClase();

    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion (`idClase`, `idSocio`, `fechaInscripcion`) VALUES (?,?,?); ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getSocio().getIdSocio());
            ps.setInt(2, insc.getClase().getIdClase());
            ps.setDate(3, Date.valueOf(insc.getFechaInscripcion()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Asistencia registrada con exito. ID: " + insc.getIdInscripcion());
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de la Inscripcion" + e.getMessage());
        }

    }

    public List<Inscripcion> listarInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT DISTINCT inscripcion.* FROM socios,inscripcion,clases WHERE socios.estado=1 AND clases.estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                Clase cla = ac.buscarClase(rs.getInt("idClase"));
                Socio soc = as.buscarSocio(rs.getInt("idSocio"));
                inscripcion.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());
                inscripcion.setClase(cla);
                inscripcion.setSocio(soc);
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones" + e.getMessage());
        }
        return inscripciones;

    }

    //Listar especiales
    public List<Inscripcion> listarInscripcionesPorConsulta(String consulta) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                Clase cla = ac.buscarClase(rs.getInt("idClase"));
                Socio soc = as.buscarSocio(rs.getInt("idSocio"));
                inscripcion.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());
                inscripcion.setClase(cla);
                inscripcion.setSocio(soc);
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + e.getMessage());
        }
        return inscripciones;
    }

    public List<Inscripcion> listarAsistenciasPorId() {
        String consulta = "SELECT * FROM inscripcion ORDER BY idInscripcion ASC;";
        return listarInscripcionesPorConsulta(consulta);
    }

    public List<Inscripcion> listarAsistenciasPorIdSocio() {
        String consulta = "SELECT * FROM inscripcion ORDER BY idInscripcion ASC;";
        return listarInscripcionesPorConsulta(consulta);
    }

    public List<Inscripcion> listarAsistenciasPorIdClases() {
        String consulta = "SELECT * FROM inscripcion ORDER BY idInscripcion ASC;";
        return listarInscripcionesPorConsulta(consulta);
    }

    public List<Inscripcion> listarAsistenciasPorFecha() {
        String consulta = "SELECT * FROM inscripcion ORDER BY fechaInscripcion ASC;";
        return listarInscripcionesPorConsulta(consulta);
    }

    public Inscripcion buscarInscripcionPorId(int id) {
        Inscripcion insc = null;

        String sql = "SELECT * FROM inscripcion WHERE idInscripcion=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                insc = new Inscripcion();
                insc.setIdInscripcion(id);
                insc.setClase(ac.buscarClase(rs.getInt("idClase")));
                insc.setSocio(as.buscarSocio(rs.getInt("idSocio")));
                insc.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());

            } else {
                JOptionPane.showMessageDialog(null, "No existe la Inscripcion");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + e);
        }

        return insc;
    }

    public Inscripcion buscarInscripcionPorIdSocio(int idSocio) {
        Inscripcion insc = null;

        String sql = "SELECT * FROM inscripcion WHERE idSocio=? LIMIT 1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setClase(ac.buscarClase(rs.getInt("idClase")));
                insc.setSocio(as.buscarSocio(rs.getInt("idSocio")));
                insc.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna inscripción para el socio con id " + idSocio);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + e);
        }

        return insc;
    }

    public void modificarInscripcion(Inscripcion insc) {
        String sql = "UPDATE inscripcion SET idClase = ? , idSocio = ?, fechaInscripcion = ? WHERE idInscripcion = ?";

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, insc.getSocio().getIdSocio());
            ps.setInt(2, insc.getClase().getIdClase());
            ps.setDate(3, Date.valueOf(insc.getFechaInscripcion()));
            ps.setInt(4, insc.getIdInscripcion());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion modificada");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripcion no existe");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + e);
        }

    }

    public void borrarInscripcion(int id) {
        String sql = "DELETE FROM inscripcion WHERE idInscripcion = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Inscripcion" + e.getMessage());
        }

    }

}
