package AccesoDatos;

import Entidades.Inscripcion;
import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                JOptionPane.showMessageDialog(null, "Inscripcion registrada con exito");
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

    // LISTAS PARA EL COMBOBOX ID ASISTENCIA
    public List<Inscripcion> listarInscripcionesPorIdAsistencia(int id) {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion WHERE CAST(idInscripcion AS CHAR) LIKE CONCAT('%', ? , '%') ORDER BY idInscripcion ASC;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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

    // LISTAS PARA EL COMBOBOX ID CLASE
    public List<Inscripcion> listarInscripcionesPorIdClase(int id) {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion WHERE CAST(idClase AS CHAR) LIKE CONCAT( ? ) ORDER BY idClase ASC;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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

    // LISTAS PARA EL COMBOBOX ID SOCIO
    public List<Inscripcion> listarInscripcionesPorIdSocio(int id) {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion WHERE CAST(idSocio AS CHAR) LIKE CONCAT( ? ) ORDER BY idSocio ASC;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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

    public List<Inscripcion> listarInscripcionesPorFecha(int id) {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        String sql = "SELECT * FROM inscripcion WHERE DATE_FORMAT(fecha, '%Y-%m-%d') LIKE '2023-06' ORDER BY fecha ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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
