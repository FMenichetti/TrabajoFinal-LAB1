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

        if (null != buscarMembresiaPorIdSocio(membresia.getSocio().getIdSocio())) {

            JOptionPane.showMessageDialog(null, "esa membresia ya existe");
            return;
        }

        String sql = "INSERT INTO `membresia`(`idSocio`, `cantidadPases`, `fechaInicio`, `fechaFin`, `costo`, `estado`) VALUES (?,?,?,?,?,1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, membresia.getSocio().getIdSocio());
            ps.setInt(2, membresia.getCantidadPases());
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
            JOptionPane.showMessageDialog(null, "El socio ya tiene una membresía activa" + x);
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
                membresia.setSocio(socio);
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
            String sql = "SELECT * FROM membresia WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membresia membresia = new Membresia();
                membresia.setIdMembresia(rs.getInt("idMembresia"));
                membresia.setIdSocio(rs.getInt("idSocio")); // Asigna directamente el ID del socio
                membresia.setCantidadPases(rs.getInt("cantidadPases"));
                membresia.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                membresia.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                membresia.setCosto(rs.getDouble("costo"));
                membresia.setEstado(rs.getBoolean("estado"));
                membresias.add(membresia);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla membresias: " + e.getMessage());
        }
        return membresias;
    }

    public List<Socio> listarSocioIdOrdenado() {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 ORDER BY idSocio ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Socio socio = new Socio();
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setDni(rs.getString("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(true);
                socios.add(socio);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla socio");
        }
        return socios;
    }

    public void modificarMembresia(Membresia membresia) {
        String sql = "UPDATE membresia SET idSocio = ?, cantidadPases = ?, fechaInicio = ?, fechaFin = ?, costo = ? WHERE idMembresia = ? AND estado = 1";
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
            String sql = "UPDATE membresia SET estado = 0 WHERE idMembresia = ?";
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

    //Listar especiales
    public List<Membresia> listarMembresiaPorConsulta(String consulta) {
        List<Membresia> membresias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membresia membresia = new Membresia();
                membresia.setIdMembresia(rs.getInt("idMembresia"));
                membresia.setIdSocio(rs.getInt("idSocio"));
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

    public List<Membresia> listarMembresiaPorId() {
        String consulta = "SELECT * FROM membresia WHERE estado = 1 ORDER BY idMembresia ASC;";
        return listarMembresiaPorConsulta(consulta);
    }

    public List<Membresia> listarMembresiaPorIdSocio() {
        String consulta = "SELECT * FROM membresia WHERE estado = 1 ORDER BY idSocio ASC;";
        return listarMembresiaPorConsulta(consulta);
    }

    public List<Membresia> listarMembresiaPorCantidadPases() {
        String consulta = "SELECT * FROM membresia WHERE estado = 1 ORDER BY cantidadPases ASC;";
        return listarMembresiaPorConsulta(consulta);
    }

    public List<Membresia> listarMembresiaPorFechaInicio() {
        String consulta = "SELECT * FROM membresia WHERE estado = 1 ORDER BY fechaInicio ASC;";
        return listarMembresiaPorConsulta(consulta);
    }

    public List<Membresia> listarMembresiaPorFechaFin() {
        String consulta = "SELECT * FROM membresia WHERE estado = 1 ORDER BY fechaFin ASC;";
        return listarMembresiaPorConsulta(consulta);
    }

    public List<Membresia> listarMembresiaPorCosto() {
        String consulta = "SELECT * FROM membresia WHERE estado = 1 ORDER BY costo ASC;";
        return listarMembresiaPorConsulta(consulta);
    }

}
