package AccesoDatos;

import Entidades.Membresia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AccesoMembresia {

    private Connection con;

    public AccesoMembresia() {
        con = Conexion.getConexion();
    }

    public void crearMembresia(Membresia membresia) {
        String sql = "INSERT INTO `membresias`(`idSocio`, `tipo`, `fechaInicio`, `fechaFin`, `estado`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, membresia.getIdSocio());
            ps.setString(2, membresia.getTipo());
            ps.setDate(3, Date.valueOf(membresia.getFechaInicio()));
            ps.setDate(4, Date.valueOf(membresia.getFechaFin()));
            ps.setBoolean(5, membresia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
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
        String sql = "SELECT `idMembresia`, `tipo`, `fechaInicio`, `fechaFin`, `estado` FROM `membresias` WHERE idSocio=? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                membresia = new Membresia();
                membresia.setIdMembresia(rs.getInt("idMembresia"));
                //membresia.setIdSocio(idSocio);
                membresia.setTipo(rs.getString("tipo"));
                membresia.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                membresia.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                membresia.setEstado(rs.getInt("estado") == 1);
            } else {
                JOptionPane.showMessageDialog(null, "No existe la membresía para el socio con ID: " + idSocio);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + e.getMessage());
        }
        return membresia;
    }

    public Membresia buscarMembresiaPorDniSocio(String dniSocio) {
        Membresia membresia = null;
        String sqlIdSocio = "SELECT `idSocio` FROM `socios` WHERE dni = ?";
        try {
            PreparedStatement psIdSocio = con.prepareStatement(sqlIdSocio);
            psIdSocio.setString(1, dniSocio);

            ResultSet rsIdSocio = psIdSocio.executeQuery();
            if (rsIdSocio.next()) {
                int idSocio = rsIdSocio.getInt("idSocio");

                String sqlMembresia = "SELECT `idMembresia`, `tipo`, `fechaInicio`, `fechaFin`, `estado` FROM `membresias` WHERE idSocio=? AND estado = 1";
                PreparedStatement psMembresia = con.prepareStatement(sqlMembresia);
                psMembresia.setInt(1, idSocio);

                ResultSet rsMembresia = psMembresia.executeQuery();
                if (rsMembresia.next()) {
                    membresia = new Membresia();
                    membresia.setIdMembresia(rsMembresia.getInt("idMembresia"));
                   // membresia.setIdSocio(idSocio);
                    membresia.setTipo(rsMembresia.getString("tipo"));
                    membresia.setFechaInicio(rsMembresia.getDate("fechaInicio").toLocalDate());
                    membresia.setFechaFin(rsMembresia.getDate("fechaFin").toLocalDate());
                    membresia.setEstado(rsMembresia.getInt("estado") == 1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la membresía para el socio con DNI: " + dniSocio);
                }
                psMembresia.close();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un socio con DNI: " + dniSocio);
            }
            psIdSocio.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla socios o membresias: " + e.getMessage());
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
               // membresia.setIdSocio(rs.getInt("idSocio"));
                membresia.setTipo(rs.getString("tipo"));
                membresia.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                membresia.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                membresia.setEstado(rs.getInt("estado") == 1);
                membresias.add(membresia);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + e.getMessage());
        }
        return membresias;
    }

    public void modificarMembresia(Membresia membresia) {
        String sql = "UPDATE membresias SET idSocio = ?, tipo = ?, fechaInicio = ?, fechaFin = ? WHERE idMembresia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, membresia.getIdSocio());
            ps.setString(2, membresia.getTipo());
            ps.setDate(3, Date.valueOf(membresia.getFechaInicio()));
            ps.setDate(4, Date.valueOf(membresia.getFechaFin()));
            ps.setInt(5, membresia.getIdMembresia());

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
