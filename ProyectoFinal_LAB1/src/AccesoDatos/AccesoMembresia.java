package AccesoDatos;

import Entidades.Membresia;
import Entidades.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AccesoMembresia {

    private Connection con;
    AccesoSocio as;
    public AccesoMembresia() {
        con = Conexion.getConexion();
        as = new AccesoSocio();
    }

    public void crearMembresia(Membresia membresia) {
        String sql = "INSERT INTO `membresias`(`idSocio`, `cantidadPases`, `fechaInicio`, `fechaFin`, `costo`, `estado`) VALUES (?,?,?,?,?,1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, membresia.getSocio().getIdSocio());
            ps.setInt(2,membresia.getCantidadPases());
            ps.setDate(3, Date.valueOf(membresia.getFechaInicio()));
            ps.setDate(4, Date.valueOf(membresia.getFechaFin()));
            ps.setDouble(5, membresia.getCosto());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                membresia.setIdMembresia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Membresía añadida");
            }
            ps.close();
        } catch (SQLIntegrityConstraintViolationException x) {
            JOptionPane.showMessageDialog(null, "El socio ya tiene una membresía activa");
        } catch (SQLException S) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + S);
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

    public Membresia buscarMembresiaPorIdSocio(int idSocio) {
        Membresia membresia = null;
        String sql = "SELECT * FROM `membresia` WHERE `idSocio` = ? AND `estado` = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                membresia = new Membresia();
                membresia.setIdMembresia(rs.getInt("idMembresia"));
                Socio socio = as.buscarSocio(rs.getInt("idSocio"));
                membresia.setCantidadPases(rs.getInt("cantidadPases"));
                membresia.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                membresia.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                membresia.setCosto(rs.getDouble("costo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la membresía para el socio con ID: " + idSocio);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + e.getMessage());
        }
        return membresia;
    }

    public List<Membresia> listarMembresia() {
        List<Membresia> membresias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM membresias WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membresia membresia = new Membresia();
                membresia.setIdMembresia(rs.getInt("idMembresia"));
                Socio socio = as.buscarSocio(rs.getInt("idSocio"));
                membresia.setCantidadPases(rs.getInt("cantidadPases"));
                membresia.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                membresia.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                membresia.setCosto(rs.getDouble("costo"));
                membresias.add(membresia);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + e.getMessage());
        }
        return membresias;
    }

    public void modificarMembresia(Membresia membresia) {
        String sql = "UPDATE membresias SET idSocio = ?, cantidadPases = ?, fechaInicio = ?, fechaFin = ?, costo = ? WHERE idMembresia = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, membresia.getSocio().getIdSocio());
            ps.setInt(2, membresia.getCantidadPases());
            ps.setDate(3, Date.valueOf(membresia.getFechaInicio()));
            ps.setDate(4, Date.valueOf(membresia.getFechaFin()));
            ps.setDouble(5, membresia.getCosto());
            ps.setInt(6, membresia.getIdMembresia());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Membresía modificada");
            } else {
                JOptionPane.showMessageDialog(null, "La membresía no existe");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la membresía: " + e.getMessage());
        }
    }

    public void eliminarMembresia(int id) {
        try {
            String sql = "UPDATE membresias SET estado = 0 WHERE idMembresia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó la membresía");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la membresía con el ID proporcionado");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + e.getMessage());
        }
    }
}
