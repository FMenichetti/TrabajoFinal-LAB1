package AccesoDatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AccesoClase {

    private Connection con;
    private AccesoEntrenador entData;

    public AccesoClase() {
        con = Conexion.getConexion();
        entData = new AccesoEntrenador();
    }

    public boolean guardarClase(Clase cla) {
        //usamos comodines para hacerlo generico
        boolean flag = false;
        if (existeClase(cla)) {
            JOptionPane.showMessageDialog(null, "El entrenador ya tiene clase agendada en ese horario");
            return false;
        } else {

            String sql = "INSERT INTO clases (nombre,idEntrenador,horario,capacidad,estado) "
                    + "VALUES (?,?,?,?,?)";
            try {
                //instanciamos el prepared statement para poder cargar los comodines
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                //cargamos los comodines
                ps.setString(1, cla.getNombre());
                ps.setInt(2, cla.getEntrenador().getIdEntrenador());
                ps.setTime(3, Time.valueOf(cla.getHorario()));
                ps.setInt(4, cla.getCapacidad());
                ps.setBoolean(5, cla.isEstado());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                //el resultset empieza detras de la primera columna y se fija si tiene un columna al frente
                //devuelve booleano
                if (rs.next()) {
                    cla.setIdClase(rs.getInt(1));
                    flag = true;
                    JOptionPane.showMessageDialog(null, "Clase añadida");
                }
                //cerramos la conexion
                ps.close();
            } catch (SQLIntegrityConstraintViolationException x) {
                JOptionPane.showMessageDialog(null, "La clase ya esta creada");
            } catch (SQLException S) {
                JOptionPane.showMessageDialog(null, "Error acceder a la tabla Clase " + S);

            } catch (Exception e) {
                System.out.println("error general");
            }
        }
        return flag;
    }

    public Clase buscarClase(int id) {
        Clase clase = new Clase();

        String sql = "SELECT nombre,idEntrenador,horario,capacidad,estado FROM clases WHERE idClase=? AND estado=1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clase = new Clase();

                clase.setIdClase(id);
                clase.setNombre(rs.getString("nombre"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clase.setEntrenador(trainer);

            } else {

                JOptionPane.showMessageDialog(null, "no existe la clase");
            }

            ps.close();
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }

        return clase;

    }
    
    public Clase buscarTodasLasClases(int id) {
        Clase clase = new Clase();

        String sql = "SELECT nombre,idEntrenador,horario,capacidad,estado FROM clases WHERE idClase=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clase = new Clase();

                clase.setIdClase(id);
                clase.setNombre(rs.getString("nombre"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clase.setEntrenador(trainer);

            } else {

                JOptionPane.showMessageDialog(null, "no existe la clase");
            }

            ps.close();
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }

        return clase;

    }

    public List<Clase> listarClases() {
        List<Clase> clases = new ArrayList<Clase>();
        String sql = "SELECT * FROM clases";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clases" + e.getMessage());
        }
        return clases;

    }

    public boolean modificarClase(Clase clase) {
        
        boolean flag = false;
        if (existeClase(clase)) {
            JOptionPane.showMessageDialog(null, "El entrenador ya tiene clase agendada en ese horario");
            return false;
        } else {
        
        String sql = "UPDATE clases SET nombre = ? , idEntrenador = ?, horario = ?, capacidad = ?, estado = ? WHERE idClase =  ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.setInt(6, clase.getIdClase());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                flag = true;
                JOptionPane.showMessageDialog(null, "Clase modificada");
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clases" + e);
        }
        return flag;
    }
    }
    
      public void modificarClaseFabri(Clase clase) {
        

        String sql = "UPDATE clases SET nombre = ? , idEntrenador = ?, horario = ?, capacidad = ?, estado = ? WHERE idClase =  ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.setInt(6, clase.getIdClase());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                
                JOptionPane.showMessageDialog(null, "Clase modificada");
            } else {
                JOptionPane.showMessageDialog(null, "La clase no existe");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clases" + e);
        }
        
    
    }

    //borrado logico de clase
    public boolean eliminarClase(int id) {

        boolean flag = false;

        try {

            String sql = "UPDATE clases SET estado = 0 WHERE idClase = ? AND estado=1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                flag = true;
                JOptionPane.showMessageDialog(null, " Se eliminó la clase.");

            } else if (fila == 0) {
                JOptionPane.showMessageDialog(null, "No existe la clase");
            }
            ps.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla clase");
        }
        return flag;
    }

    public boolean existeClase(Clase clase) {

        String sql = "SELECT * FROM `clases` WHERE `horario`=? and `idEntrenador`=? and estado=1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setTime(1, Time.valueOf(clase.getHorario()));

            ps.setInt(2, clase.getEntrenador().getIdEntrenador());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return true;
            }
        } catch (SQLException e) {
            System.out.println("" + e);

        }
        return false;
    }

    public List<Clase> listarClaseIdOrdenado() {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 ORDER BY idClase ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseCapacidadOrdenado() {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 ORDER BY capacidad ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseNombreOrdenado() {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 ORDER BY nombre ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseEntrenadorOrdenado() {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases c, entrenadores e WHERE c.estado = 1 and e.estado = 1 and c.idEntrenador = e.idEntrenador  ORDER BY e.nombre ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseHorarioOrdenado() {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 ORDER BY horario ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseIdFiltro(int id) {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 AND CAST(idClase AS CHAR) LIKE CONCAT('%', ? , '%') ORDER BY idClase ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseCapacidadFiltro(int num) {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 AND CAST(capacidad AS CHAR) LIKE CONCAT('%', ? , '%') ORDER BY capacidad ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseNombreFiltro(String nombre) {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 AND nombre LIKE CONCAT('%', ?, '%') ORDER BY nombre ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseEntrenadorFiltro(String nombre) {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases c, entrenadores e WHERE c.estado = 1 and e.estado = 1 and c.idEntrenador = e.idEntrenador AND e.nombre  LIKE CONCAT('%', ?, '%') ORDER BY e.nombre ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public List<Clase> listarClaseHorarioFiltro(int id) {
        List<Clase> clases = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clases WHERE estado = 1 AND CAST(horario AS CHAR) LIKE CONCAT('%', ? , '%') ORDER BY horario ASC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setEntrenador(trainer);
                clase.setEstado(true);
                clases.add(clase);

            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clase");
        }
        return clases;
    }

    public void eliminarMultiplesClases(int idClase) {

        try {

            String sql = "UPDATE clases SET estado = 0 WHERE idClase = ? AND estado=1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);

            int fila = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla clase");
        }

    }

    public List<Clase> listarClasesPorEntrenador(int idEntrenador) {
        List<Clase> clases = new ArrayList<Clase>();
        String sql = "SELECT * FROM `clases` WHERE estado=1 AND idEntrenador=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEntrenador);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("idClase"));
                clase.setNombre(rs.getString("nombre"));
                Entrenador trainer = entData.buscarEntrenador(rs.getInt("idEntrenador"));
                clase.setHorario(rs.getTime("horario").toLocalTime());
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clases" + e.getMessage());
        }
        return clases;

    }

}
