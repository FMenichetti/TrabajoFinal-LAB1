package AccesoDatos;

import Entidades.Entrenador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AccesoEntrenador {

    
    private Connection con;

    public AccesoEntrenador() {
        con = Conexion.getConexion();
    }

    public void guardarEntrenador(Entrenador entrenador) {
        //usamos comodines para hacerlo generico
        String sql = "INSERT INTO entrenador (dni,nombre,apellido,especialidad,estado) "
                + "VALUES (?,?,?,?,?)";
        try {
            //instanciamos el prepared statement para poder cargar los comodines
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //cargamos los comodines
            ps.setString(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            //el resultset empieza detras de la primera columna y se fija si tiene un columna al frente
            //devuelve booleano
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entrenador añadido");  

            }
            //cerramos la conexion
            ps.close();
        } 
        catch(SQLIntegrityConstraintViolationException x){
            JOptionPane.showMessageDialog(null, "El entrenador ya esta cargado");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador "+ e);

        } catch (Exception e) {
            System.out.println("error general");
        }

    }

    public Entrenador buscarEntrenador(int id) {
        Entrenador entrenador = null;

        String sql = "SELECT dni,nombre,apellido,especialidad FROM entrenador WHERE idEntrenador=? AND estado=1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                entrenador = new Entrenador();

                entrenador.setIdEntrenador(id);
                entrenador.setDni(rs.getString("dni"));
                entrenador.setApellido(rs.getString("nombre"));
                entrenador.setNombre(rs.getString("apellido"));
                entrenador.setNombre(rs.getString("especialidad"));
                entrenador.setEstado(true);

            } else {

                JOptionPane.showMessageDialog(null, "No existe el entrenador");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
            System.out.println(e);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error general");
            System.out.println(e);
        }

        return entrenador;
    }

    public Entrenador buscarEntrenadorPorDni(String dni) {
        Entrenador entrenador = null;

        String sql = "SELECT idEntrenador, dni, nombre, apellido, especialidad FROM entrenador WHERE dni=? AND estado = 1";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
                entrenador.setDni(dni);
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el entrenador");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
        }

        return entrenador;
    }

//    public List<Entrenador> listarEntrenador() {
//        List<Entrenador> lista = new ArrayList<>();
//
//        try {
//            String sql = "SELECT * FROM entrenador WHERE estado = 1 ";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Entrenador entrenador = new Entrenador();
//
//                entrenador.setIdEntrenador(rs.getInt("idEntrenador"));
//                entrenador.setDni(rs.getString("dni"));
//                entrenador.setNombre(rs.getString("nombre"));
//                entrenador.setApellido(rs.getString("apellido"));
//                entrenador.setEspecialidad(rs.getString("fechaNacimiento"));
//                entrenador.setEstado(true);
//                lista.add(entrenador);
//
//            }
//            ps.close();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
//        }
//
//        return entrenadors;
//    }
//
//    public void modificarEntrenador(Entrenador entrenador) {
//        String sql = "UPDATE entrenador SET dni = ? , apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idEntrenador =  ?";
//
//        PreparedStatement ps = null;
//
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, entrenador.getDni());
//            ps.setString(2, entrenador.getApellido());
//            ps.setString(3, entrenador.getNombre());
//            ps.setDate(4, Date.valueOf(entrenador.getFechaNacimiento()));
//            ps.setInt(5, entrenador.getIdEntrenador());
//            
//            int exito = ps.executeUpdate();
//
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Entrenador modificado");
//            } else {
//                JOptionPane.showMessageDialog(null, "El entrenador no existe");
//            }
//
//        } catch (SQLException e) {
//
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
//        }
//
//    }
//
//    public void eliminarEntrenador(int id) {
//
//        try {
//
//            String sql = "UPDATE entrenador SET estado = 0 WHERE idEntrenador = ? ";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//
//            int fila = ps.executeUpdate();
//
//            if (fila == 1) {
//                JOptionPane.showMessageDialog(null, " Se eliminó el entrenador.");
//
//            }
//            ps.close();
//        } catch (SQLException e) {
//
//            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Entrenador");
//        }
//
//    }
//    
}
