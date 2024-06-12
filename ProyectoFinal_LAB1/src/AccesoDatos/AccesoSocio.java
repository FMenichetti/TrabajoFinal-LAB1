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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AccesoSocio {

    private Connection con;
    private AccesoMembresia am;

    public AccesoSocio() {
        con = Conexion.getConexion();
        //am = new AccesoMembresia();

    }

    public boolean guardarSocio(Socio socio) {
        boolean flag = false;
        String sql = "INSERT INTO socios (dni,nombre,apellido,edad,correo,telefono,estado) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                flag = true;
                JOptionPane.showMessageDialog(null, "Socio añadido");

            }

            ps.close();

        } catch (SQLIntegrityConstraintViolationException x) {
            JOptionPane.showMessageDialog(null, "El socio ya esta cargado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al acceder al socio");
        }
        return flag;
    }

    public Socio buscarSocio(int id) {
        Socio socio = null;

        String sql = "SELECT dni,nombre,apellido,edad,correo,telefono FROM socios WHERE idSocio=? AND estado=1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                socio = new Socio();
                socio.setDni(rs.getString("dni"));
                socio.setIdSocio(id);
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(true);
            } else {

                JOptionPane.showMessageDialog(null, "No existe el socio");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar socio");
        }
        return socio;
    }

    public Socio buscarSocioPorDni(String dni) {
        Socio socio = null;
        String sql = "SELECT idSocio,dni,nombre,apellido,edad,correo,telefono FROM socios WHERE dni = ? AND estado=1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setDni(rs.getString("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el socio");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar socio");
        }

        return socio;
    }

    public List<Socio> listarSocio() {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 ";
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

    public boolean modificarSocio(Socio socio) {
        boolean flag = false;
        //Comparo id de parametro con id de busqueda
        if (socio.getIdSocio() == buscarSocio(socio.getIdSocio()).getIdSocio()) {
            JOptionPane.showMessageDialog(null, "Cuidado, ya existe un socio con ese dni");
            return false;
        } else {

            String sql = "UPDATE socios SET dni = ?, nombre = ?, apellido = ?, edad = ? , correo = ? , telefono = ?  WHERE idSocio = ?";

            PreparedStatement ps = null;

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, socio.getDni());
                ps.setString(2, socio.getNombre());
                ps.setString(3, socio.getApellido());
                ps.setInt(4, socio.getEdad());
                ps.setString(5, socio.getCorreo());
                ps.setString(6, socio.getTelefono());
                ps.setInt(7, socio.getIdSocio());

                int exito = ps.executeUpdate();

                if (exito == 1) {
                    flag = true;
                    JOptionPane.showMessageDialog(null, "Socio modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "El Socio no existe");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla socio" + e);
            }
            return flag;
        }
    }

    public boolean eliminarSocio(int id) {

        boolean flag = false;
        try {
            //Membresia m = new Membresia();
            //m = am.buscarMembresiaPorIdSocio(id);

            String sql = "UPDATE socios SET estado = 0 WHERE idSocio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                flag = true;
                //am.eliminarMembresia(m.getIdMembresia());
                JOptionPane.showMessageDialog(null, "Baja logica al socio.");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Socio");

        }
        return flag;
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

    public List<Socio> listarSocioDniOrdenado() {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 ORDER BY dni ASC;";
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

    public List<Socio> listarSocioNombreOrdenado() {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 ORDER BY nombre ASC;";
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

    public List<Socio> listarSocioApellidoOrdenado() {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 ORDER BY apellido ASC;";
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

    public List<Socio> listarSocioIdFiltro(int id) {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 AND CAST(idSocio AS CHAR) LIKE CONCAT('%', ? , '%') ORDER BY idSocio ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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

    public List<Socio> listarSocioDniFiltro(String dni) {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 AND dni LIKE CONCAT('%', ?, '%') ORDER BY dni ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
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

    public List<Socio> listarSocioNombreFiltro(String nombre) {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 AND nombre LIKE CONCAT('%', ?, '%') ORDER BY nombre ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
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

    public List<Socio> listarSocioApellidoFiltro(String apellido) {
        List<Socio> socios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM socios WHERE estado = 1 AND apellido LIKE CONCAT('%', ?, '%') ORDER BY apellido ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, apellido);
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
}
