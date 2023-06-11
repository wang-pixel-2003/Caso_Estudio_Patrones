package Backend.Model.Libro;

import Backend.Model.Persona.Persona;
import Backend.Model.dl.ConexionBD;
import Backend.Model.dl.TestConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta funcion lo que hace es insertar en la tabla libros, el libro con sus titulo, autor, categoria.
 */
public class LibroDAO {
    public void registrarLibro(String titulo, String autor, String categoria){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "INSERT INTO Libros (id_libro, titulo, autor, categoria, estado) VALUES (nextval('SEC_TIPO_LIBROS'),?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,titulo);
            ps.setString(2,autor);
            ps.setString(3,categoria);
            ps.setInt(4, 0);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }

    /**
     * Esta funcion lo que hace es llamar la informacion de la tabla libros.
     * @return
     */
    public ArrayList<Libro> mostrarListaLibros() {
        ArrayList<Libro> list = new ArrayList<Libro>();
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT lb.id_libro, lb.titulo, lb.autor, lb.categoria, lb.estado FROM LIBROS lb";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Libro lb= new Libro();

                lb.setIdLibro(rs.getInt(1));
                lb.setTitulo(rs.getString(2));
                lb.setAutor(rs.getString(3));
                lb.setCategoria(rs.getString(4));
                lb.setEstado(rs.getInt(5));
                list.add(lb);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }

        con.desconectarBD();
        return list;
    }

    public ArrayList<Libro> mostrarListaLibrosDisponibles() {
        ArrayList<Libro> list = new ArrayList<Libro>();
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT lb.id_libro, lb.titulo, lb.autor, lb.categoria, lb.estado FROM LIBROS lb WHERE lb.estado = 0 ";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Libro lb= new Libro();

                lb.setIdLibro(rs.getInt(1));
                lb.setTitulo(rs.getString(2));
                lb.setAutor(rs.getString(3));
                lb.setCategoria(rs.getString(4));
                lb.setEstado(rs.getInt(5));
                list.add(lb);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }

        con.desconectarBD();
        return list;
    }

    /**
     * Esta funcion actualiza la informacion de los libros en la tabla de libros, agarra el estado, titulo.
     * @param titulo
     */
    public void modificarDisponible(String titulo){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "UPDATE Libros Set estado=? WHERE titulo=?";

        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2,titulo);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }

    /**
     * Esta funcion lo que hace es modificar el
     * @param titulo
     */
    public void modificarApartado(String titulo){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "UPDATE Libros Set estado=? WHERE titulo=?";

        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2,titulo);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }
    public void agregarPrestamoLibros(Persona usuario, String libro){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT * FROM libros WHERE titulo = ?";
        String sql2 = "";
        sql2 = "INSERT INTO prestamos_libros (id_prestamo, id_usuario, id_libro, fecha_devolucion) VALUES (nextval('SEC_PRESTAMOS_LIBROS'),?,?,CURRENT_DATE)";
//        String sql3 = "";
//        sql3 = "UPDATE  SET estado=? WHERE titulo=?";
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        Libro libro1 = new Libro();
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, libro);
            rs = ps.executeQuery();
            if (rs.next()) {
                libro1.setIdLibro(rs.getInt("id_libro"));
            }
            ps2 = con.getConnection().prepareStatement(sql2);
            ps2.setInt(1, usuario.getId());
            ps2.setInt(2, libro1.getIdLibro());
            ps2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                ps2.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }
    public void devolverPrestamoLibros(Persona usuario, String libro){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT * FROM libros WHERE titulo = ?";
        String sql2 = "";
        sql2 = "DELETE FROM prestamos_libros WHERE id_usuario=? AND id_libro=?";
//        String sql3 = "";
//        sql3 = "UPDATE  SET estado=? WHERE titulo=?";
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        Libro libro1 = new Libro();
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, libro);
            rs = ps.executeQuery();
            if (rs.next()) {
                libro1.setIdLibro(rs.getInt("id_libro"));
            }
            ps2 = con.getConnection().prepareStatement(sql2);
            ps2.setInt(1, usuario.getId());
            ps2.setInt(2, libro1.getIdLibro());
            ps2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                ps2.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }

    /**
     * Funcion que realiza una busqueda en la bd para retirar los libros que han sido prestaods por un usuario
     * @param usuario
     * @return
     */
    public ArrayList<Libro> librosUsuario(String usuario) {
        ArrayList<Libro> list = new ArrayList<Libro>();
        ConexionBD con = new ConexionBD();
        String sql;
        sql = "SELECT Lib.id_libro, Lib.titulo, Lib.autor, Lib.categoria, Lib.estado\n" +
                "FROM prestamos_libros AS PL\n" +
                "INNER JOIN usuarios AS U ON PL.id_usuario = U.id_usuario \n" +
                "INNER JOIN libros AS Lib ON Lib.id_libro = PL.id_libro\n" +
                "WHERE U.username = '"+ usuario +"'";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Libro lb= new Libro();

                lb.setIdLibro(rs.getInt(1));
                lb.setTitulo(rs.getString(2));
                lb.setAutor(rs.getString(3));
                lb.setCategoria(rs.getString(4));
                lb.setEstado(rs.getInt(5));
                list.add(lb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }

        con.desconectarBD();
        return list;
    }
}
